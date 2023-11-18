package com.example.misc;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (var server = new ServerSocket(9999)) {
            Socket client = server.accept();
            Thread.sleep(2000);
            var in = client.getInputStream();
            System.out.println("Incoming " + in.toString());
            in.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
