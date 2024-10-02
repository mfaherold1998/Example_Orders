package com.example.orders.exceptions;

import org.springframework.http.HttpStatus;

public class AlreadyExistsException extends CustomException{

    public AlreadyExistsException (String message, String details){super(message, details, HttpStatus.CONFLICT);}
}
