package com.controllers;

import com.main.Misc;

import java.io.IOException;

public class ServerController {

    Misc misc = new Misc();

    public void serverLog() throws IOException {
        misc.openWindow("serverWindow.fxml", "server Log", 640, 413);
    }
}
