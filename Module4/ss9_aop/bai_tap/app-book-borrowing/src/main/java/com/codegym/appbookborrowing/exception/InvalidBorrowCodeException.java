package com.codegym.appbookborrowing.exception;

public class InvalidBorrowCodeException extends RuntimeException{
    public InvalidBorrowCodeException(String message) {
        super(message);
    }
}
