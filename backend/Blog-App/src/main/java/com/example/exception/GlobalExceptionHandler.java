package com.example.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PostNotFoundByPostIdException.class)
    public ResponseEntity<String> handlePostNotFoundException(PostNotFoundByPostIdException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler(PostNotFoundByUserException.class)
    public ResponseEntity<String> handlePostOperationException(PostNotFoundByUserException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
    }

    // Add more exception handlers for other exceptions

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Internal Server Error: " + e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleArgNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> resMap = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName =((FieldError)error).getField();
            String errorMessage = error.getDefaultMessage();
            resMap.put(fieldName, errorMessage);

        });
        return new ResponseEntity<>(resMap, HttpStatus.BAD_REQUEST);
    }
}