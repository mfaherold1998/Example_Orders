package com.example.orders.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidException extends CustomException{

    public InvalidException(String message, String details){super(message, details, HttpStatus.BAD_REQUEST);}
}
