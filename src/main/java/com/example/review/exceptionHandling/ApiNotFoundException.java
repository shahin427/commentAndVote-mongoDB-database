package com.example.review.exceptionHandling;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiNotFoundException extends RuntimeException {
    private final String message;
    private final HttpStatus httpStatus;

    public ApiNotFoundException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;

    }
}
