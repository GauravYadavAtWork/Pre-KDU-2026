package com.KDU.BookInventoryApp.dto.response;

public class BookResponse {

    private int serialNumber;
    private String name;
    private String authorName;
    private Double price;

    public BookResponse(int serialNumber, String name, String authorName, Double price) {
        this.serialNumber = serialNumber;
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

    public Double getPrice() {
        return price;
    }
}
