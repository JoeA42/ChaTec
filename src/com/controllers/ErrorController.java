package com.controllers;

import com.main.Misc;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ErrorController {

    public Button errorWindowOk;
    Misc misc = new Misc();
    Stage stage = new Stage();

    /**
     * This method loads an error Window when called
     * @throws IOException
     */
    public void errorWindow() throws IOException {
        Stage stage = new Stage();
        misc.openWindow("../resources/ErrorWindow.fxml", "Error", 258, 82);

    }

    /**
     * This closes the window on press
     * @param actionEvent
     */
    public void okButton(ActionEvent actionEvent) {
        Stage stage = (Stage) errorWindowOk.getScene().getWindow();
        stage.close();
    }
}