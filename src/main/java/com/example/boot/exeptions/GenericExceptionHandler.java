package com.example.boot.exeptions;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<GenericException> notFound() {
        return new ResponseEntity<>(new GenericException(GenericErrorCode.NOT_FOUND, "Error when fetching data"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<GenericException> validationError() {
        return new ResponseEntity<>(new GenericException(GenericErrorCode.BAD_REQUEST, "Error when validating"), HttpStatus.BAD_REQUEST);
    }

}
