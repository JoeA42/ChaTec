package com.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class ServerProtocol extends Thread{
    private Consumer<Serializable> onReceiveCallback;
    int port;

    public ServerProtocol(int port) {
        this.port = port;
    }

    public void run(){
        System.out.println("Server started on port: " + port);
        try(ServerSocket server = new ServerSocket(port);
            Socket socket = server.accept();
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
            socket.setTcpNoDelay(true);

            while (true) {

                Serializable data = (Serializable) in.readObject();
                out.writeObject(data);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection Ended");
        }
    }
}