package com.example.feature.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MessageConfiguration {

    /**
     * Manual create a bean
     *
     * @return helloWorldBean
     */
    @Bean
    MessageBean helloWorldBean() {
        return new MessageBean();
    }

}
