package com.example.orders.exceptions;

import org.springframework.http.HttpStatus;

public class MappingException extends CustomException{

    public MappingException(String message, String details){super(message,details, HttpStatus.MULTI_STATUS);}
}
