package org.example.backend;

public class AreaNotFoundException extends Exception{
    public AreaNotFoundException() {
    }

    public AreaNotFoundException(String message) {
        super(message);
    }
}
