package org.example.backend;

import java.time.Instant;
import java.time.LocalDateTime;

public record ErrorMessage(String message, LocalDateTime timestamp) {
    public ErrorMessage(String message) {
        this(message, new TimestampService().getTime());
    }
}
