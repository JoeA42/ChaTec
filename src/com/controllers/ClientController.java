package com.controllers;

import com.communication.ClientProtocol;
import com.main.Misc;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientController{
    /**
     * Min Declaration
     */
    String userName;
    Misc misc = new Misc();
    public TextField ipAddress;
    public TextArea chatWindowClient = null;
    public TextField textInputClient = null;
    public TextField portField = null;

    /**
     * method to open the chat window with the provided username
     * @param user username provided from previous method
     * @throws IOException
     */
    public void clientChat(String user) throws IOException {
            userName = user;
            Stage stage = new Stage();
            misc.openWindow("../resources/ClientWindow.fxml", userName+"'s chat'", 640, 413);
    }

    /**
     *a method that interacts with the button
     * @param event sendButton press
     */
    public void sendButton(javafx.event.ActionEvent event) {
        String text = misc.textReader(textInputClient);
        System.out.println("Client: "+text);
        misc.textWriter(text,chatWindowClient,"Client: ");
    }

    /**
     * the same thing as previous method, but with the enter key
     * @param keyEvent Enter Key
     */
    public void onEnter(ActionEvent keyEvent) {
        String text = misc.textReader(textInputClient);
        System.out.println("Client: "+text);
        misc.textWriter(text,chatWindowClient,"Client: ");
    }

    /**
     * this begins the client connection and provides the necessary details from the available fields
     * @param event
     */
    public void connectButton(ActionEvent event) {
        String ip = misc.textReader(ipAddress);
        String portString= misc.textReader(portField);
        int port = Integer.parseInt(portString);
        ClientProtocol clientProtocol = new ClientProtocol(ip,port);
        clientProtocol.start();
    }
}