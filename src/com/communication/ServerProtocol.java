package com.communication;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerProtocol extends Thread{
    int port;

    /**
     * Constructor for server, it determines the port number the server will start on
     * @param portNumber int that determines port number
     */
    public ServerProtocol(int portNumber){
        port = portNumber;
    }

    /**
     * Thread of the server protocol, I wanted to do a server that would just read all inputs and send them out again to create a group chat
     * but I was unable to determine how to do so.
     */
    public void run() {
        // starts server and waits for a connection
        try
        {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            //initialize socket and input stream
            Socket socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";

            // reads message from client until "Over" is sent
            while (!line.equals("Over"))
            {
                try
                {
                    line = in.readUTF();
                    System.out.println(line);

                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");

            // close connection
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

}
