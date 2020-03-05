package com.controllers;
import com.communication.ServerProtocol;
import com.main.Misc;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * This is the main window Controllers, FXML uses controllers to handle the interaction with the GUI.
 * There are some limitations, controllers cannot have constructors, also they cannot run threads because limitations with javaFX
 * Instead of using threads, you need to use tasks or Executor(which im not sure what it is or how to use)
 */
public class MainController{
    /**
     * Here I call elements in the GUI using the specific object declarator, such as TextField.
     * I also start a server on port 5000
     * and create an instance of the class Misc, which I created to handle repeat code on the windows and to add modularity
     */
    public TextField userID = null;
    ServerProtocol serverProtocol = new ServerProtocol(5000);
    Misc misc = new Misc();

    /**
     *
     * @param event
     * this method calls an ActionEvent which is the pressing of the button, and then runs the chatMaker method from misc, using the userID as a parameter.
     * @throws IOException
     */

    public void openChat(ActionEvent event) throws IOException {
        misc.chatMaker(userID);
    }

    /**
     * this method does the exact same thing, except it does with with a keyEvent which is the pressing of the enterKey
     * @param keyEvent
     * @throws IOException
     */
    public void enterKey(ActionEvent keyEvent) throws IOException {
        misc.chatMaker(userID);
    }

    /**
     * this method calls for the server to begin on a button press, the server runs on a separate Thread
     * @param event
     */
    public void startServer(ActionEvent event) {
        System.out.println("Starting server on port 5000");
        serverProtocol.start();
    }

}


