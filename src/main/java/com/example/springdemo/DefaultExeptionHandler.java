package com.example.springdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springdemo.exeption.ErrorCode;
import com.example.springdemo.exeption.GenericApiExeption;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class DefaultExeptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> notFoundEntity() {
        return new ResponseEntity<>(new GenericApiExeption(ErrorCode.NOT_FOUND, "Error when fetching data"), HttpStatus.NOT_FOUND);
    }
    
}
