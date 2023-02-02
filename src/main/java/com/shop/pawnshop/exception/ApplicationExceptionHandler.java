package com.shop.pawnshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleOwnerNotFoundException(NotFoundException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        //serializes to Json
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
