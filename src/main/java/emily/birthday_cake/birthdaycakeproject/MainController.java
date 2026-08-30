package emily.birthday_cake.birthdaycakeproject;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class MainController {

    @FXML
    private ImageView flame;

    @FXML
    private ImageView flameWhenHovered;

    @FXML
    private StackPane flamesStackedPane;


    public void initialize(){
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
        distortAnimation.setByY(-0.5);
        distortAnimation.setAutoReverse(true);
        distortAnimation.play();

        flamesStackedPane.hoverProperty().addListener((observable, notHovering, isHovering) -> {
            if (isHovering){
                flame.setVisible(false);
                flameWhenHovered.setVisible(true);

            }
            else {
                flame.setVisible(true);
                flameWhenHovered.setVisible(false);
            }
        });
    }



}
