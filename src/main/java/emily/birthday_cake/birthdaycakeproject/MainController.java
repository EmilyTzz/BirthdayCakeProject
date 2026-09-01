package emily.birthday_cake.birthdaycakeproject;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainController {

    @FXML
    private ImageView flame;

    @FXML
    private ImageView flameWhenHovered;

    @FXML
    private StackPane flamesStackedPane;

    @FXML
    private HBox happyBdayText;

    @FXML
    private VBox windBlowBar;

    private int hoverCount = 0;

    private int numberOfProgressBlocks = 0;

    @FXML
    private AnchorPane windBlowerDisplay;

    @FXML
    private ImageView instructionsText;

    @FXML
    private ImageView envelopIcon;

    @FXML
    private ImageView baloons1;

    @FXML
    private ImageView baloons2;


    private Stage letterStage;

    private Scene letterScene;

    /**
     * This method helps to initialize the secondary stage and scene passed on from the main class
     * @param letterStage
     * @param letterScene
     */
    public void initData(Stage letterStage, Scene letterScene){
        this.letterStage = letterStage;
        this.letterScene = letterScene;
    }

    /**
     * This method helps to initialize the visibility of the initial display and animations
     */
    public void initialize(){
        happyBdayText.setVisible(false); // let the hpbd text be invisible first
        flame.setVisible(true); // have the flames be visible at first
        flameWhenHovered.setVisible(false);
        baloons1.setVisible(false); // have the baloons be invisible at first
        baloons2.setVisible(false);

        ScaleTransition scaleTransition = new ScaleTransition(); // have the flames be scaled repeatedly to make a glowing animation
        scaleTransition.setNode(flame);
        scaleTransition.setDuration(Duration.millis(1000));
        scaleTransition.setCycleCount(Animation.INDEFINITE);
        scaleTransition.setInterpolator(Interpolator.LINEAR);
        scaleTransition.setByX(-0.2); // have the flames become smaller
        scaleTransition.setByY(-0.2);
        scaleTransition.setAutoReverse(true); // have the flames be smaller and back to big repeatedly
        scaleTransition.play();

        ScaleTransition distortAnimation = new ScaleTransition();
        distortAnimation.setNode(flameWhenHovered); // have the hovered flame have a different animation
        distortAnimation.setDuration(Duration.millis(1000));
        distortAnimation.setCycleCount(Animation.INDEFINITE);
        distortAnimation.setInterpolator(Interpolator.LINEAR);
        distortAnimation.setByX(-1); // have the hovered flame be distorted to make a movement effect
        distortAnimation.setByY(0.4);
        distortAnimation.setAutoReverse(true);
        distortAnimation.play();

        ScaleTransition instructionsAnimations = new ScaleTransition();
        instructionsAnimations.setNode(instructionsText); // have the instructions text have an animation as well
        instructionsAnimations.setDuration(Duration.millis(1000));
        instructionsAnimations.setCycleCount(Animation.INDEFINITE);
        instructionsAnimations.setInterpolator(Interpolator.LINEAR);
        // have the text be scaled big to small repeatedly
        instructionsAnimations.setByX(0.3);
        instructionsAnimations.setByY(0.3);
        instructionsAnimations.setAutoReverse(true);
        instructionsAnimations.play();

        // have the happy birthday text be scaled big to small repeatedly
        ScaleTransition happyBdayAnimation = new ScaleTransition();
        happyBdayAnimation.setNode(happyBdayText);
        happyBdayAnimation.setDuration(Duration.millis(1000));
        happyBdayAnimation.setCycleCount(Animation.INDEFINITE);
        happyBdayAnimation.setInterpolator(Interpolator.LINEAR);
        happyBdayAnimation.setByX(0.3);
        happyBdayAnimation.setByY(0.3);
        happyBdayAnimation.setAutoReverse(true);
        happyBdayAnimation.play();

        // track if the user hovered over the flames
        flamesStackedPane.hoverProperty().addListener((observable, notHovering, isHovering) -> {
            if (isHovering){
                // if the user is hovering, set the stack flame as the distorted flame
                flame.setVisible(false);
                flameWhenHovered.setVisible(true);
                addToBlowProcessBar(); // add 1 block to the blow progress bar
                if (numberOfProgressBlocks >= 20){ // if the progress bar has 20 blocks already then transition to the happy birthday display
                    instructionsText.setVisible(false);
                    happyBdayText.setVisible(true);
                    windBlowerDisplay.setVisible(false);
                    flame.setVisible(false);
                    flameWhenHovered.setVisible(false);
                    baloonAnimations();
                    letterAnimations();
                }
            }
            else {
                if (numberOfProgressBlocks >= 20){
                    // if the progress bar is filled, stop showing the flames
                    flame.setVisible(false);
                }
                else {
                    // when user is not hovering over the flames, show the normal flames
                    flame.setVisible(true);
                    flameWhenHovered.setVisible(false);
                }
            }
        });

    }

    /**
     * This method manages the visibility and animations of the baloons
     */
    private void baloonAnimations(){
        // have the baloons be visible
        baloons1.setVisible(true);
        baloons2.setVisible(true);

        // Have the baloons shift up and down
        TranslateTransition baloon1Animations = new TranslateTransition();
        baloon1Animations.setNode(baloons1);
        baloon1Animations.setDuration(Duration.millis(1000));
        baloon1Animations.setCycleCount(TranslateTransition.INDEFINITE);
        baloon1Animations.setByY(20);
        baloon1Animations.setAutoReverse(true);
        baloon1Animations.play();

        TranslateTransition baloon2Animations = new TranslateTransition();
        baloon2Animations.setNode(baloons2);
        baloon2Animations.setDuration(Duration.millis(1000));
        baloon2Animations.setCycleCount(TranslateTransition.INDEFINITE);
        baloon2Animations.setByY(20);
        baloon2Animations.setAutoReverse(true);
        baloon2Animations.play();
    }

    /**
     * This method manages the animations for the birthday envelop
     */
    private void letterAnimations(){
        // Have the envelop transition up once the user blew out the candle
        TranslateTransition envelopAnimations = new TranslateTransition();
        envelopAnimations.setNode(envelopIcon);
        envelopAnimations.setDuration(Duration.millis(1000));
        envelopAnimations.setCycleCount(1);
        envelopAnimations.setByY(-200);
        envelopAnimations.play();
        envelopIcon.setOnMouseClicked(event ->{
            loadLetter(); // when user clicks the envelop, open the secondary stage for the letter
        });
    }

    /**
     * This method creates the secondary window for viewing the letter
     */
    private void loadLetter(){
        envelopIcon.setVisible(false);
        letterStage.setTitle("My Birthday Letter to You");
        letterStage.setScene(letterScene);
        letterStage.show();
    }

    /**
     * This method adds a block to the current blow progress bar whenever the user hover over/pass the candle flames
     */
    private void addToBlowProcessBar(){
        if (numberOfProgressBlocks == 20){ // don't add any blocks if the bar has 20 blocks already
            return;
        }
        hoverCount += 1;
        // add a new block to the vbox/bar
        HBox progressBlock = new HBox();
        progressBlock.setPrefHeight(7.48);
        windBlowBar.getChildren().add(progressBlock);
        progressBlock.setStyle("-fx-background-color: #79ecc3;");
        numberOfProgressBlocks += 1;
    }


}
