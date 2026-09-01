package emily.birthday_cake.birthdaycakeproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is responsible for launching the program
 */
public class MainGUI extends Application {

    /**
     * This method creates the primary and secondary stage of the program and run JavaFX
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        // creates the primary stage
        FXMLLoader fxmlLoader = new FXMLLoader(MainGUI.class.getResource("mainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 528, 370);
        stage.setTitle("Happy Birthday!");
        stage.setResizable(false); // Don't allow user to resize screen
        MainController mainController = fxmlLoader.getController();

        // creates the secondary stage for the letter
        FXMLLoader letterViewLoader = new FXMLLoader(MainGUI.class.getResource("letterView.fxml"));
        Scene letterScene = new Scene(letterViewLoader.load(), 284, 354);
        Stage letterStage = new Stage();
        letterStage.setResizable(false);

        // pass in the secondary stage and scene to the main controller
        mainController.initData(letterStage, letterScene);

        stage.setScene(scene);
        stage.show();
    }
}
