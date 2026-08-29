package emily.birthday_cake.birthdaycakeproject;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class MainController {

    @FXML
    private ImageView flame;

    public void initialize(){
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(flame);
        scaleTransition.setDuration(Duration.millis(1000));
        scaleTransition.setCycleCount(TranslateTransition.INDEFINITE);
        scaleTransition.setInterpolator(Interpolator.LINEAR);
        scaleTransition.setByX(-0.2);
        scaleTransition.setByY(-0.2);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

    }

}
