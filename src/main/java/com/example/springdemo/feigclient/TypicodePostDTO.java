package com.example.springdemo.feigclient;

import lombok.Data;

@Data
public class TypicodePostDTO {
    private Integer id;
    private String userId;
    private String title;
    private String body;
}
