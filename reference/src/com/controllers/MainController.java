package com.controllers;

import com.communication.NetworkConnection;
import com.communication.ServerProtocol;
import com.main.ActiveUsers;
import com.main.Misc;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MainController{

    public TextField userID = null;
    public TextField portNumber = null;
    public TextField ipAddress = null;
    private NetworkConnection connection;
    public TextArea chatWindowClient = null;
    Misc misc = new Misc();
    ActiveUsers activeUsers = new ActiveUsers();
    ServerProtocol serverProtocol;


    public void openChat(ActionEvent event) throws Exception {
        String user = misc.textGetter(userID);
        String ip = misc.textGetter(ipAddress);
        String port = misc.textGetter(portNumber);
        int portNumber = Integer.parseInt(port);
        misc.addUser(user, activeUsers);
        misc.chatMaker(user);

    }
    public void serverLog(ActionEvent event) throws IOException {
            ServerController serverController = new ServerController();
            serverController.serverLog();
    }

    public void startServer(ActionEvent event) {
        serverProtocol = new ServerProtocol(5555);
        serverProtocol.start();
    }

    public void enterKey(ActionEvent keyEvent) throws Exception {
        String user = misc.textGetter(userID);
        String ip = misc.textGetter(ipAddress);
        String port = misc.textGetter(portNumber);
        int portNumber = Integer.parseInt(port);
        misc.addUser(user, activeUsers);
        misc.chatMaker(user);
    }

}


