package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("bmi.fxml"));
        primaryStage.setTitle("BMI calculator");
        primaryStage.setScene(new Scene(root, 350, 480));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
