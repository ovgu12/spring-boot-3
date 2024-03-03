package com.example.feature;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("a")
@Slf4j
public class MessageBean implements Message {

    public void hi() {
        log.info("I am a MessageBean");
    }

}
