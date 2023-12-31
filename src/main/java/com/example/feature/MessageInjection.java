package com.example.feature;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageInjection {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(MessageConfiguration.class);

        var helloWorldBean = ctx.getBean("a", Message.class);
        helloWorldBean.hi();

        var helloWorldComponent = ctx.getBean(MessageComponent.class);
        helloWorldComponent.hi();

        ctx.close();
    }

}
