package com.communication;

import java.io.Serializable;
import java.util.function.Consumer;

public class ClientProtocol extends NetworkConnection {

    private String ip;
    private int port;

    public ClientProtocol(String ip, int port, Consumer<Serializable> onReceiveCallback) {
        super(onReceiveCallback);
        this.ip = ip;
        this.port = port;
    }

    @Override
    protected String getIP() {
        return "localhost";
    }

    @Override
    protected int getPort() {
        return 5555;
    }
}