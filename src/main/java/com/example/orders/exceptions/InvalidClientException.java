package com.example.orders.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidClientException extends CustomException{

    public InvalidClientException (String message, String details){super(message, details, HttpStatus.BAD_REQUEST);}
}
