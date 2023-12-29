package org.example.backend;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler()
    @ResponseStatus()
    public String handleException (MealNotFoundException exception) {
        return "a new exception";
    }
}
