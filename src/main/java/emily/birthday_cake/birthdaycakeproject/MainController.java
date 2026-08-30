package emily.birthday_cake.birthdaycakeproject;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

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

    public void initialize(){
        happyBdayText.setVisible(false); // let the hpbd text be invisible first
        flame.setVisible(true);
        flameWhenHovered.setVisible(false);
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(flame);
        scaleTransition.setDuration(Duration.millis(1000));
        scaleTransition.setCycleCount(Animation.INDEFINITE);
        scaleTransition.setInterpolator(Interpolator.LINEAR);
        scaleTransition.setByX(-0.2);
        scaleTransition.setByY(-0.2);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        ScaleTransition distortAnimation = new ScaleTransition();
        distortAnimation.setNode(flameWhenHovered);
        distortAnimation.setDuration(Duration.millis(1000));
        distortAnimation.setCycleCount(Animation.INDEFINITE);
        distortAnimation.setInterpolator(Interpolator.LINEAR);
        distortAnimation.setByX(-1);
        distortAnimation.setByY(0.4);
        distortAnimation.setAutoReverse(true);
        distortAnimation.play();

        ScaleTransition instructionsAnimations = new ScaleTransition();
        instructionsAnimations.setNode(instructionsText);
        instructionsAnimations.setDuration(Duration.millis(1000));
        instructionsAnimations.setCycleCount(Animation.INDEFINITE);
        instructionsAnimations.setInterpolator(Interpolator.LINEAR);
        instructionsAnimations.setByX(0.3);
        instructionsAnimations.setByY(0.3);
        instructionsAnimations.setAutoReverse(true);
        instructionsAnimations.play();

        ScaleTransition happyBdayAnimation = new ScaleTransition();
        happyBdayAnimation.setNode(happyBdayText);
        happyBdayAnimation.setDuration(Duration.millis(1000));
        happyBdayAnimation.setCycleCount(Animation.INDEFINITE);
        happyBdayAnimation.setInterpolator(Interpolator.LINEAR);
        happyBdayAnimation.setByX(0.3);
        happyBdayAnimation.setByY(0.3);
        happyBdayAnimation.setAutoReverse(true);
        happyBdayAnimation.play();

        flamesStackedPane.hoverProperty().addListener((observable, notHovering, isHovering) -> {
            if (isHovering){
                flame.setVisible(false);
                flameWhenHovered.setVisible(true);
                addToBlowProcessBar();
                if (numberOfProgressBlocks >= 20){
                    instructionsText.setVisible(false);
                    happyBdayText.setVisible(true);
                    windBlowerDisplay.setVisible(false);
                    flame.setVisible(false);
                    flameWhenHovered.setVisible(false);
                }
            }
            else {
                if (numberOfProgressBlocks >= 20){
                    flame.setVisible(false);
                }
                else {
                    flame.setVisible(true);
                    flameWhenHovered.setVisible(false);
                }
            }
        });

    }

    private void addToBlowProcessBar(){
        if (numberOfProgressBlocks == 20){
            return;
        }
        hoverCount += 1;
        HBox progressBlock = new HBox();
        progressBlock.setPrefHeight(7.48);
        windBlowBar.getChildren().add(progressBlock);
        progressBlock.setStyle("-fx-background-color: #79ecc3;");
        numberOfProgressBlocks += 1;
    }




}
