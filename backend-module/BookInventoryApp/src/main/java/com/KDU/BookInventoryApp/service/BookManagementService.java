package com.KDU.BookInventoryApp.service;

import com.KDU.BookInventoryApp.dto.request.AddNewBookRequest;
import com.KDU.BookInventoryApp.dto.request.BookSearchQueryRequest;
import com.KDU.BookInventoryApp.dto.response.ApiResponse;
import com.KDU.BookInventoryApp.dto.response.BookResponse;
import com.KDU.BookInventoryApp.exception.domin.book.BookNotFoundException;
import com.KDU.BookInventoryApp.exception.domin.book.DuplicateBookFoundException;
import com.KDU.BookInventoryApp.exception.domin.miscellaneous.DuplicateDataException;
import com.KDU.BookInventoryApp.model.Book;
import com.KDU.BookInventoryApp.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookManagementService {
    private final BookRepository bookRepository;

    public BookManagementService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public ApiResponse<BookResponse> addNewBook(AddNewBookRequest request){
        try{
            Book book = bookRepository.insert(request.getName(), request.getAuthorName(), request.getPrice(), request.getISBN());
            BookResponse response = new BookResponse(
                    book.getSerialNumber(),
                    book.getName(),
                    book.getAuthorName(),
                    book.getPrice(),
                    book.getISBN()
            );
            return new ApiResponse<>(200, "Book Added Successfully", response);
        }catch (DuplicateDataException exception){
            throw new DuplicateBookFoundException("Book Already Exists!");
        }
    }

    public ApiResponse<BookResponse> findBookBySerialNumber(int serialNumber){
        Book book = bookRepository.findBySerialNumber(serialNumber);
        if(book == null) throw new BookNotFoundException("Book with serial number " + serialNumber + " not found");
        BookResponse response = new BookResponse(
                book.getSerialNumber(),
                book.getName(),
                book.getAuthorName(),
                book.getPrice(),
                book.getISBN()
        );
        return new ApiResponse<>(200, "book found", response);
    }

    public ApiResponse<BookResponse> findBookByISBN(String ISBN){
        Book book = bookRepository.findByISBN(ISBN);
        if(book == null) throw new BookNotFoundException("Book with ISBN " + ISBN + " not found");
        BookResponse response = new BookResponse(
                book.getSerialNumber(),
                book.getName(),
                book.getAuthorName(),
                book.getPrice(),
                book.getISBN()
        );
        return new ApiResponse<>(200, "book found", response);
    }

    public ApiResponse<List<BookResponse>> findAll(BookSearchQueryRequest request){
        List<BookResponse> mapping = new ArrayList<>();
        List<Book> books = bookRepository.findAll(
                request.getName(),
                request.getAuthorName(),
                request.getMinPrice(),
                request.getMaxPrice()
        );
        if(books.isEmpty()) throw new BookNotFoundException("No Record Found");
        for(Book book: books){
            mapping.add(new BookResponse(
                    book.getSerialNumber(),
                    book.getName(),
                    book.getAuthorName(),
                    book.getPrice(),
                    book.getISBN())
            );
        }
        return new ApiResponse<>(200, "List of Books", mapping);
    }

    public ApiResponse<String> remove(int serialNumber){
        bookRepository.removeBook(serialNumber);
        return new ApiResponse<>(200, "Record Deleted Successfully", "Book with id:" + serialNumber + " Deleted");
    }
}
