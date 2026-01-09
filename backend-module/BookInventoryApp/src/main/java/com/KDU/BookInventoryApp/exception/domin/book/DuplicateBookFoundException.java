package com.KDU.BookInventoryApp.exception.domin.book;

public class DuplicateBookFoundException extends RuntimeException{
    public DuplicateBookFoundException(String message) {
        super(message);
    }
}
