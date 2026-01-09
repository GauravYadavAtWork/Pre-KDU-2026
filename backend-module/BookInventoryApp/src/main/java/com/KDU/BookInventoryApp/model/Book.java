package com.KDU.BookInventoryApp.model;

public class Book {
    private static int totalBooks = 0;
    private int serialNumber;
    private String name;
    private String authorName;
    private Double price;
    private String ISBN;

    public Book(String name, String authorName, Double price, String ISBN){
        this.serialNumber = ++totalBooks;
        this.name = name;
        this.authorName = authorName;
        this.price = price;
        this.ISBN = ISBN;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public double getPrice() {
        return price;
    }

    public String getISBN() {
        return ISBN;
    }
}
