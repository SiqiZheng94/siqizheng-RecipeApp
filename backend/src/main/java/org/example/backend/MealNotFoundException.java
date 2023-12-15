package org.example.backend;

public class MealNotFoundException extends Exception {
    public MealNotFoundException() {
    }

    public MealNotFoundException(String message) {
        super(message);
    }
}
