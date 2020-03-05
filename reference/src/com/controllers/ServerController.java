package com.controllers;

import com.main.Misc;
import javafx.stage.Stage;

import java.io.IOException;

public class ServerController {

    Misc misc = new Misc();
    Stage stage;

    public void serverLog() throws IOException {
        stage = new Stage();
        misc.windowMaker(stage, "serverWindow.fxml", "server Log", 640, 413);
    }
}
