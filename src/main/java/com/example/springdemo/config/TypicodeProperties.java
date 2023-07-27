package com.example.springdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "typicode")
@PropertySource("classpath:typicode.properties")
@Data
public class TypicodeProperties {
    private String host;
}
