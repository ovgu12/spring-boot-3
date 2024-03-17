package com.example.feature.di;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Slf4j
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
        log.info("Hi " + myText);
    }

}
