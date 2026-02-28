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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class BookManagementServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookManagementService bookManagementService;

    @Test
    void addNewBook_shouldReturnApiResponseWithBookResponse() {

        AddNewBookRequest request =
                new AddNewBookRequest("Clean Code", "Robert C. Martin", 450.0, "ISBN11111");

        Book savedBook = new Book(
                "Clean Code",
                "Robert C. Martin",
                450.0,
                "ISBN11111"
        );

        when(bookRepository.insert(
                request.getName(),
                request.getAuthorName(),
                request.getPrice(),
                request.getISBN()
        )).thenReturn(savedBook);

        ApiResponse<BookResponse> response =
                bookManagementService.addNewBook(request);

        assertNotNull(response);
        assertEquals(200, response.getStatus());
        assertEquals("Book Added Successfully", response.getMessage());

        BookResponse bookResponse = response.getData();
        assertNotNull(bookResponse);
        assertEquals("Clean Code", bookResponse.getName());
        assertEquals("Robert C. Martin", bookResponse.getAuthorName());
        assertEquals(450.0, bookResponse.getPrice());

        verify(bookRepository, times(1))
                .insert("Clean Code", "Robert C. Martin", 450.0, "ISBN11111");
    }

    @Test
    void addNewBook_shouldThrowException_whenRepositoryFails() {

        AddNewBookRequest request =
                new AddNewBookRequest("Clean Code", "Robert C. Martin", 450.0, "ISBN11111");

        when(bookRepository.insert(
                request.getName(),
                request.getAuthorName(),
                request.getPrice(),
                request.getISBN()
        )).thenThrow(new RuntimeException("Database failure"));

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> bookManagementService.addNewBook(request)
        );

        assertEquals("Database failure", exception.getMessage());

        verify(bookRepository, times(1))
                .insert("Clean Code", "Robert C. Martin", 450.0, "ISBN11111");
    }

    @Test
    void addNewBook_shouldThrowDuplicateBookFoundException_whenDuplicateDataExists() {

        AddNewBookRequest request =
                new AddNewBookRequest("Clean Code", "Robert C. Martin", 450.0, "ISBN11111");

        when(bookRepository.insert(
                request.getName(),
                request.getAuthorName(),
                request.getPrice(),
                request.getISBN()
        )).thenThrow(new DuplicateDataException("Duplicate record"));

        DuplicateBookFoundException exception = assertThrows(
                DuplicateBookFoundException.class,
                () -> bookManagementService.addNewBook(request)
        );

        assertEquals("Book Already Exists!", exception.getMessage());

        verify(bookRepository, times(1))
                .insert("Clean Code", "Robert C. Martin", 450.0, "ISBN11111");
    }

    @Test
    void findAll_shouldReturnBookList_whenBooksMatchQuery() {

        BookSearchQueryRequest request = new BookSearchQueryRequest();
        request.setName("Clean");
        request.setAuthorName("");
        request.setMinPrice(0.0);
        request.setMaxPrice(1000.0);

        List<Book> dummyBooks = List.of(
                new Book("Clean Code", "Robert C. Martin", 450.0, "ISBN11111"),
                new Book("Clean Architecture", "Robert C. Martin", 500.0, "ISBN11112")
        );

        when(bookRepository.findAll(
                request.getName(),
                request.getAuthorName(),
                request.getMinPrice(),
                request.getMaxPrice()
        )).thenReturn(dummyBooks);

        ApiResponse<List<BookResponse>> response =
                bookManagementService.findAll(request);

        assertNotNull(response);
        assertEquals(200, response.getStatus());
        assertEquals("List of Books", response.getMessage());

        List<BookResponse> data = response.getData();
        assertNotNull(data);
        assertEquals(2, data.size());

        assertEquals("Clean Code", data.get(0).getName());
        assertEquals("Robert C. Martin", data.get(0).getAuthorName());
        assertEquals(450.0, data.get(0).getPrice());

        assertEquals("Clean Architecture", data.get(1).getName());

        verify(bookRepository, times(1))
                .findAll(
                        request.getName(),
                        request.getAuthorName(),
                        request.getMinPrice(),
                        request.getMaxPrice()
                );
    }

    @Test
    void findAll_shouldThrowBookNotFoundException_whenNoBooksFound() {

        BookSearchQueryRequest request = new BookSearchQueryRequest();
        request.setName("Unknown");
        request.setAuthorName("");
        request.setMinPrice(0.0);
        request.setMaxPrice(1000.0);

        when(bookRepository.findAll(
                request.getName(),
                request.getAuthorName(),
                request.getMinPrice(),
                request.getMaxPrice()
        )).thenReturn(Collections.emptyList());

        BookNotFoundException exception = assertThrows(
                BookNotFoundException.class,
                () -> bookManagementService.findAll(request)
        );

        assertEquals("No Record Found", exception.getMessage());

        verify(bookRepository, times(1))
                .findAll(
                        request.getName(),
                        request.getAuthorName(),
                        request.getMinPrice(),
                        request.getMaxPrice()
                );
    }
}
