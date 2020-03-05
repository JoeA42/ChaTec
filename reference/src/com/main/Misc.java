package com.main;

import com.controllers.ClientController;
import com.controllers.ErrorController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Misc {

    public void windowMaker(Stage stage,String window, String title, int width, int height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane root = fxmlLoader.load(getClass().getResource(window).openStream());
        stage.setTitle(title);
        stage.setScene(new Scene(root, width, height));
        stage.show();
    }

    public void addUser(String user, ActiveUsers userList){
        userList.add(user);
    }

    public void removeUser(String user, ArrayList userList){
        userList.remove(user);
    }

    public String textGetter(TextField textField) throws IOException {
        if (textField.getText().isEmpty()) {
            ErrorController errorController = new ErrorController();
            errorController.errorWindow();
        }
        else{
            String string = textField.getText();
            textField.clear();
            return string;
        }
        return null;
    }

    public String textReader(TextField textInput){
        String text = textInput.getText();
        textInput.clear();

        return text;
    }

    public void textWriter(String text, TextArea chatWindow, String user){
        chatWindow.appendText(user + text + "\n");

    }

    public void chatMaker(String userID) throws Exception {
        ClientController clientController = new ClientController();
        clientController.init();
    }

    public void socketConnector(Socket socket, String address, int port){
    }
    
    /*
    public void sendMessage(String message) throws IOException {
        out.writeUTF(message);

    }
    */
}

