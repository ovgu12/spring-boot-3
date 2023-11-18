package com.example.misc;

import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try (Socket client = new Socket("localhost", 9999)) {
            var out = client.getOutputStream();
            out.write(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
