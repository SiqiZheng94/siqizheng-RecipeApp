package org.example.backend.exception;

import org.example.backend.service.TimestampService;

import java.time.LocalDateTime;

public record ErrorMessage(String message, LocalDateTime timestamp) {
    public ErrorMessage(String message) {
        this(message, new TimestampService().getTime());
    }
}
