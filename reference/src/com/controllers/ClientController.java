package com.controllers;

import com.communication.ClientProtocol;
import com.communication.NetworkConnection;
import com.main.Misc;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClientController extends Application {


    Misc misc = new Misc();
    public TextArea chatWindowClient = null;
    public TextField textInputClient = null;
    NetworkConnection connection = new ClientProtocol("127.0.0.1", 5555, data->{
        Platform.runLater(()-> {
            chatWindowClient.appendText(data.toString()+"\n");
        });
    });

    @Override
    public void init() throws Exception {
        connection.startConnection();

    }

    @Override
    public void start(Stage stage) throws Exception {
        misc.windowMaker(stage,"../resources/ClientWindow.fxml", "test"+"'s chat'", 640, 413);
    }

    @Override
    public void stop() throws Exception {
        connection.closeConnection();
    }

    public void sendButton(javafx.event.ActionEvent event) throws Exception {
        String text = misc.textReader(textInputClient);
        connection.send(text);
    }

    public void onEnter(ActionEvent keyEvent) throws Exception {
        String text = misc.textReader(textInputClient);
        connection.send(text);
    }

}
