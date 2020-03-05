package com.communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientProtocol extends Thread{
    // initialize socket and input output streamsc
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;
    String address;
    int port;

    /**
     * This method constructs a Client with the parameters requested and stabilises on a new Thread a communication channel
     * @param ipAddress String that determines the ipAddress, can be localhost
     * @param portNumber int that defines the port number
     */
    public ClientProtocol(String ipAddress, int portNumber) {
        address = ipAddress;
        port = portNumber;
    }
        // constructor to put ip address and port

    /**
     * This overWriters the run method, so the client can be created on an individual Thread
     * is the main loop for the client server communication
     * However I was not able to determine a way of sending messages using the GUI I created, the connection is established between server and client, but no messages are sent
     */
    public void run(){
        // establishes a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connection Established");

            // takes input from terminal
            input = new DataInputStream(System.in);

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        // string to read message from input
        String line = "";

        // keep reading until "Over" is input
        while (!line.equals("Over"))
        {
            try
            {
                line = input.readUTF();
                out.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }

        // close the connection
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
}
