package com.KDU.BookInventoryApp.exception.domin.miscellaneous;

public class DuplicateDataException extends RuntimeException{
    public DuplicateDataException(String message){
        super(message);
    }
}
