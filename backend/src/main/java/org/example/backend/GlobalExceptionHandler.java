package org.example.backend;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private TimestampService timestampService;
    @ExceptionHandler()
    @ResponseStatus()
    public ErrorMessage handleException (NotFoundException exception) {

        return new ErrorMessage(exception.getMessage());
    }
}
