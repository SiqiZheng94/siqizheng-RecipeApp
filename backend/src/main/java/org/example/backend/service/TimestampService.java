package org.example.backend.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class TimestampService {
    public LocalDateTime getTime(){
        return LocalDateTime.now();
    }
}
