package com.KDU.BookInventoryApp.controller;

import com.KDU.BookInventoryApp.dto.request.AddNewBookRequest;
import com.KDU.BookInventoryApp.dto.request.BookSearchQueryRequest;
import com.KDU.BookInventoryApp.dto.response.ApiResponse;
import com.KDU.BookInventoryApp.dto.response.BookResponse;
import com.KDU.BookInventoryApp.service.BookManagementService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookManagementService bookManagementService;

    public BookController(BookManagementService bookManagementService){
        this.bookManagementService = bookManagementService;
    }

    @GetMapping("/find")
    public ApiResponse<List<BookResponse>> findAllBooksQuery(@ModelAttribute BookSearchQueryRequest queryRequest){
        return bookManagementService.findAll(queryRequest);
    }

    @GetMapping("/find/{serialNumber}")
    public ApiResponse<BookResponse> findBookBySerialNumber(@PathVariable int serialNumber){
        return bookManagementService.findBookBySerialNumber(serialNumber);
    }

    @GetMapping("/find/ISBN/{ISBN}")
    public ApiResponse<BookResponse> findBookByISBN(@PathVariable String ISBN){
        return bookManagementService.findBookByISBN(ISBN);
    }

    @PostMapping("/add")
    public ApiResponse<BookResponse> addNewBook(@Valid @RequestBody AddNewBookRequest request){
        return bookManagementService.addNewBook(request);
    }

    @DeleteMapping("/remove/{serialNumber}")
    public ApiResponse<String> removeBook(@PathVariable int serialNumber){
        return bookManagementService.remove(serialNumber);
    }
}
