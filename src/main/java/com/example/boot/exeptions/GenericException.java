package com.example.boot.exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GenericException {
    private GenericErrorCode code;
    private String message;
}
