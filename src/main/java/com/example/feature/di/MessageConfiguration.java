package com.example.feature.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan
public class MessageConfiguration {

    /**
     * Manual create a bean
     *
     * @return helloWorldBean
     */
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    MessageBean helloWorldBean() {
        return new MessageBean();
    }

}
