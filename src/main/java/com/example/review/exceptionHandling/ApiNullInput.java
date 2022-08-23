package com.example.review.exceptionHandling;

public class ApiNullInput extends RuntimeException{
    public ApiNullInput(String message) {
        super(message);
    }
}
