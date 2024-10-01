package com.example.orders.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class CustomException extends RuntimeException{

    private Date timestamp;
    private String message;
    private String details;
    private HttpStatus httpStatus;

    public CustomException(String message, String details, HttpStatus httpStatus) {
        this.timestamp = new Date();
        this.message = message;
        this.details = details;
        this.httpStatus = httpStatus;
    }



}
