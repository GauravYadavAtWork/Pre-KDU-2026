package com.KDU.BookInventoryApp.repository;

import com.KDU.BookInventoryApp.exception.domin.book.BookNotFoundException;
import com.KDU.BookInventoryApp.exception.domin.miscellaneous.DuplicateDataException;
import com.KDU.BookInventoryApp.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepository {
    private List<Book> books = new ArrayList<>(Arrays.asList(
            new Book("Clean Code", "Robert C. Martin", 450.0, "ISBN11111"),
            new Book("Effective Java", "Joshua Bloch", 650.0, "ISBN11112"),
            new Book("Design Patterns", "Erich Gamma", 700.0, "ISBN11113"),
            new Book("Java Concurrency in Practice", "Brian Goetz", 800.0, "ISBN11114"),
            new Book("Spring in Action", "Craig Walls", 550.0, "ISBN11115"),
            new Book("Head First Java", "Kathy Sierra", 400.0, "ISBN11116"),
            new Book("Refactoring", "Martin Fowler", 720.0, "ISBN11117"),
            new Book("Microservices Patterns", "Chris Richardson", 900.0, "ISBN11118"),
            new Book("Domain-Driven Design", "Eric Evans", 850.0, "ISBN11119"),
            new Book("The Pragmatic Programmer", "Andrew Hunt", 600.0, "ISBN11120")
    ));

    public List<Book> findAll(String name, String authorName, Double minPrice, Double maxPrice){
        List<Book> result = new ArrayList<>();
        for(Book book: books){
            if(book.getName().contains(name) &
            book.getAuthorName().contains(authorName) &
            book.getPrice() >= minPrice & book.getPrice() <= maxPrice)
            {
                result.add(book);
            }
        }
        return result;
    }

    public Book insert(String name, String authorName, Double price, String ISBN){
        for(Book book: books){
            if((book.getName().equals(name) && book.getAuthorName().equals(authorName)) || book.getISBN().equals(ISBN)){
                throw new DuplicateDataException("Duplicate Record exists");
            }
        }
        Book book = new Book(name, authorName, price, ISBN);
        books.add(book);
        return book;
    }

    public Book findBySerialNumber(int serialNumber){
        for(Book book: books){
            if(book.getSerialNumber() == serialNumber) return book;
        }
        return null;
    }

    public Book findByISBN(String ISBN){
        for(Book book: books){
            if(book.getISBN().equals(ISBN)) return book;
        }
        return null;
    }

    public void removeBook(int serialNumber){
        int indextoremove = -1;
        for(int i=0;i<books.size();i++){
            if(books.get(i).getSerialNumber() == serialNumber) indextoremove = i;
        }
        if(indextoremove == -1) throw new BookNotFoundException("Book not found");
        else books.remove(indextoremove);
    }
}
