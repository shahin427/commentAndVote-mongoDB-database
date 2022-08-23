package com.example.review.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiNotFoundException.class)
    public ResponseEntity<ApiNotFoundException> handleExistenceInDataBaseExceptionWithOkStatus(ApiNotFoundException e) {
        ApiNotFoundException apiInputIsInComplete = new ApiNotFoundException(e.getMessage(), e.getHttpStatus());
        return new ResponseEntity<>(apiInputIsInComplete, e.getHttpStatus());
    }

    @ExceptionHandler(value = ApiNullInput.class)
    public ResponseEntity<ApiNullInput> handleExistenceInDataBaseExceptionWithOkStatus(ApiNullInput e) {
        HttpStatus httpStatus = HttpStatus.NON_AUTHORITATIVE_INFORMATION;
        ApiNullInput apiException = new ApiNullInput(e.getMessage());
        return new ResponseEntity<>(apiException, httpStatus);
    }

}