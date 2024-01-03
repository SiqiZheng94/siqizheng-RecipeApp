package org.example.backend;

import java.time.LocalDateTime;

public class TimestampService {
    public static LocalDateTime getTime(){
        return LocalDateTime.now();
    }

}
