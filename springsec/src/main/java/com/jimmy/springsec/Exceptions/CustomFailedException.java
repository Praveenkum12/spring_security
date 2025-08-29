package com.jimmy.springsec.Exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class CustomFailedException extends RuntimeException {

    public CustomFailedException(String message) {
        super(message);
    }
}
