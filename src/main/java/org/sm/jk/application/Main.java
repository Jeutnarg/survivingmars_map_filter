package org.sm.jk.application;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("initial_screen.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.setPrimaryStage(primaryStage);
        primaryStage.setTitle("SM* MapFinder");
        primaryStage.setScene(new Scene(root, 1300, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
