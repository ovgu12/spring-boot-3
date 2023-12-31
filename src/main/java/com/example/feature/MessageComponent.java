package com.example.feature;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MessageComponent implements Message {

    @Value("World")
    private final String myText;

    /**
     * myText will not be overridden
     */
    public MessageComponent(@Value("Value") String text) {
        myText = text;
    }

    public void hi() {
        System.out.println("Hi " + myText);
    }

}
