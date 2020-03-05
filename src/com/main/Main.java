package com.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    /**
     * I start the main method using javaFX and the extended .FXML protocol to load the main window
     * @param primaryStage placeholder argument used by javaFX to load the main window
     * @throws Exception to window
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../resources/mainWindow.fxml"));
        primaryStage.setTitle("ChaTecV2");
        primaryStage.setScene(new Scene(root, 334, 204));
        primaryStage.show();
    }

    /**
     * this is just the main method that launches the application
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
