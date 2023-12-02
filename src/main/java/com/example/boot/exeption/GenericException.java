package com.example.boot.exeption;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GenericException {
    private GenericErrorCode code;
    private String message;
}
