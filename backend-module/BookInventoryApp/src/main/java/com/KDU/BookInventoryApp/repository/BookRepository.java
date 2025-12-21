package com.KDU.BookInventoryApp.repository;

import com.KDU.BookInventoryApp.exception.domin.miscellaneous.DuplicateDataException;
import com.KDU.BookInventoryApp.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepository {
    private List<Book> books = new ArrayList<>(Arrays.asList(
            new Book("Clean Code", "Robert C. Martin", 450.0),
            new Book("Effective Java", "Joshua Bloch", 650.0),
            new Book("Design Patterns", "Erich Gamma", 700.0),
            new Book("Java Concurrency in Practice", "Brian Goetz", 800.0),
            new Book("Spring in Action", "Craig Walls", 550.0),
            new Book("Head First Java", "Kathy Sierra", 400.0),
            new Book("Refactoring", "Martin Fowler", 720.0),
            new Book("Microservices Patterns", "Chris Richardson", 900.0),
            new Book("Domain-Driven Design", "Eric Evans", 850.0),
            new Book("The Pragmatic Programmer", "Andrew Hunt", 600.0)
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

    public Book insert(String name, String authorName, Double price){
        for(Book book: books){
            if(book.getName().equals(name) && book.getAuthorName().equals(authorName)){
                throw new DuplicateDataException("Duplicate Record exists");
            }
        }
        Book book = new Book(name, authorName, price);
        books.add(book);
        return book;
    }

    public Book findBySerialNumber(int serialNumber){
        for(Book book: books){
            if(book.getSerialNumber() == serialNumber) return book;
        }
        return null;
    }
}
