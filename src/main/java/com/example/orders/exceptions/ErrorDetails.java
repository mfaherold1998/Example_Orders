package com.example.orders.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
    private HttpStatus httpStatus;

    public ErrorDetails(CustomException customException) {
        this.timestamp = customException.getTimestamp();
        this.message = customException.getMessage();
        this.details = customException.getDetails();
    }
}
