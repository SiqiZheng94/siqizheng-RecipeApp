package org.example.backend;

public class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException(){
    }
    public CategoryNotFoundException(String message){
        super(message);
    }
}
