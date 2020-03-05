package com.controllers;

import com.main.Misc;
import javafx.event.ActionEvent;
import javafx.stage.*;
import javafx.scene.control.*;

import java.io.IOException;

public class ErrorController {

    public Button errorWindowOk;
    Misc misc = new Misc();
    Stage stage = new Stage();


    public void errorWindow() throws IOException {
        Stage stage = new Stage();
        misc.windowMaker(stage,"../resources/ErrorWindow.fxml", "Error", 258, 82);

    }

    public void okButton(ActionEvent actionEvent) {
        Stage stage = (Stage) errorWindowOk.getScene().getWindow();
        stage.close();
    }
}