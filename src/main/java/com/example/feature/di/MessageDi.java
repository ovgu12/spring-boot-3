package com.example.feature.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageDi {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(MessageConfiguration.class);

        var helloWorldBean = ctx.getBean("helloWorldBean", Message.class);
        helloWorldBean.hi();

        var helloWorldComponent = ctx.getBean(MessageComponent.class);
        helloWorldComponent.hi();

        ctx.close();
    }

}
