package com.example.boot.cloud;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "typicode")
@PropertySource("classpath:typicode.properties")
@Data
public class TypicodeProperties {
    private String host;
}
