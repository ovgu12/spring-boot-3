package com.example.springdemo.exeption;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GenericApiExeption {
    private ErrorCode code;
    private String message;
}
