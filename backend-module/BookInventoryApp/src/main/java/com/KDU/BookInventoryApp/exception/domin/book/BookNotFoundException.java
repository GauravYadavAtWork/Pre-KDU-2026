package com.KDU.BookInventoryApp.exception.domin.book;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message) {
        super(message);
    }
}
