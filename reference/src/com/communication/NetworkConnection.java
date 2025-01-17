package com.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.function.Consumer;

public abstract class NetworkConnection {

    private ConnectionThread connectionThread = new ConnectionThread();
    private Consumer<Serializable> onReceiveCallback;

    public NetworkConnection(Consumer<Serializable> onReceiveCallback){
        this.onReceiveCallback = onReceiveCallback;
        connectionThread.setDaemon(true);
    }

    public void startConnection() throws Exception {
        connectionThread.start();

    }

    public void send(Serializable data) throws Exception {
        connectionThread.out.writeObject(data);


    }

    public void closeConnection() throws Exception {
        connectionThread.socket.close();

    }

    protected abstract String getIP();
    protected abstract int getPort();


    private class ConnectionThread extends Thread {
        private Socket socket;
        private ObjectOutputStream out;

        public void run(){
            try(Socket socket = new Socket((getIP()),getPort());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

                this.socket = socket;
                this.out = out;
                socket.setTcpNoDelay(true);

                while (true) {
                    Serializable data = (Serializable) in.readObject();
                    onReceiveCallback.accept(data);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Connection Ended");
            }
        }
    }
}
