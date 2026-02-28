package com.KDU.BookInventoryApp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class AddNewBookRequest {

    @NotBlank(message = "Book name is required")
    @Size(min = 2, max = 100, message = "Book name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Author name is required")
    @Size(min = 2, max = 100, message = "Author name must be between 2 and 100 characters")
    private String authorName;

    @Positive(message = "Price must be greater than zero")
    private Double price;

    @NotBlank(message = "ISBN is required")
    @Size(min = 9, max = 9, message = "9 Length ISBN code is required")
    private String ISBN;

    public AddNewBookRequest() {}

    public AddNewBookRequest(String name, String authorName, Double price, String ISBN) {
        this.name = name;
        this.authorName = authorName;
        this.price = price;
        this.ISBN = ISBN;
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

    public String getISBN(){
        return ISBN;
    }
}
