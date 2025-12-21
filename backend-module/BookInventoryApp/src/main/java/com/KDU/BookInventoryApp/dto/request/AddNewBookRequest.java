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

    public AddNewBookRequest() {}

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
