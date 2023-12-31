package com.example.feature;

import org.springframework.stereotype.Component;

@Component("a")
public class MessageBean implements Message {

    public void hi() {
        System.out.println("Hello World");
    }

}
