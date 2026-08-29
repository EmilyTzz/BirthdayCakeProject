package emily.birthday_cake.birthdaycakeproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 528, 370);
        stage.setTitle("Happy Birthday!");
        stage.setScene(scene);
        stage.setResizable(false); // Don't allow user to resize screen
        stage.show();
    }
}
