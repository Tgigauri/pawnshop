package com.shop.pawnshop.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Long id) {
        super("The id '" + id + "' does not exist in our records");
    }

}
