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

/**
 * The Misc class is just a collection of reusable methods
 */
public class Misc {
    /**
     * This is a method that creates new windows,
     * @param window takes a string that will determine what resource the window is created from
     * @param title takes the name of the title that will display on the window
     * @param width takes the width for the initial loading of the window
     * @param height takes the height for the initial loading of the window
     * @throws IOException
     */
    public void openWindow(String window, String title, int width, int height) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane root = fxmlLoader.load(getClass().getResource(window).openStream());
        stage.setTitle(title);
        stage.setScene(new Scene(root, width, height));
        stage.show();
    }

    /**
     * This is a parameter that reads text from an input and returns it as a String
     * @param textInput this is where we declare the text input used on the specific window
     * @return Returns String of input
     */
    public String textReader(TextField textInput){
        String text = textInput.getText();
        textInput.clear();
        return text;
    }

    /**
     * This method takes a string, an Area to write and a Username in string from
     * @param text text that wants to be written in the area
     * @param chatWindow area where the text will be written
     * @param user userName in form of string
     */
    public void textWriter(String text, TextArea chatWindow, String user){
        chatWindow.appendText(user + text + "\n");
    }

    /**
     * This method creates chatClients if the username field has value
     * @param userID it checks for text on input and passes it to another method or it opens an errorWindow if the field is empty
     * @throws IOException
     */
    public void chatMaker(TextField userID) throws IOException {
        if (userID.getText().isEmpty()) {
            System.out.println("please enter a valid username");
            ErrorController errorController = new ErrorController();
            errorController.errorWindow();
        }
        else{
            System.out.println("starting chat window...");
            String user = userID.getText();
            System.out.println(user + " has entered the chat");
            userID.clear();
            ClientController clientController = new ClientController();
            clientController.clientChat(user);
        }
    }
}

