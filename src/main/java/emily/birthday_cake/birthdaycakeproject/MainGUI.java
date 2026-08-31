package emily.birthday_cake.birthdaycakeproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainGUI.class.getResource("mainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 528, 370);
        stage.setTitle("Happy Birthday!");
        stage.setResizable(false); // Don't allow user to resize screen
        MainController mainController = fxmlLoader.getController();

        FXMLLoader letterViewLoader = new FXMLLoader(MainGUI.class.getResource("letterView.fxml"));
        Scene letterScene = new Scene(letterViewLoader.load(), 284, 354);
        Stage letterStage = new Stage();
        letterStage.setResizable(false);

        mainController.initData(letterStage, letterScene);

        stage.setScene(scene);
        stage.show();
    }
}
