package com.KDU.BookInventoryApp.model;

public class Book {
    private static int totalBooks = 0;
    private int serialNumber;
    private String name;
    private String authorName;
    private Double price;

    public Book(String name, String authorName, Double price){
        this.serialNumber = ++totalBooks;
        this.name = name;
        this.authorName = authorName;
        this.price = price;
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
}
