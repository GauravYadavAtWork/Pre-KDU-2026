package com.KDU.BookInventoryApp.exception.handler;

import com.KDU.BookInventoryApp.dto.response.ApiErrorResponse;
import com.KDU.BookInventoryApp.exception.domin.book.DuplicateBookFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DuplicateBookFoundExceptionHandler {
    @ExceptionHandler(DuplicateBookFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleDuplicateBookFoundException(DuplicateBookFoundException exception){
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Duplicate Record Found",
                exception.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
