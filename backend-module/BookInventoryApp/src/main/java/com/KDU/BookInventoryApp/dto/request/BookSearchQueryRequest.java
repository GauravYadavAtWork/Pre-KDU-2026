package com.KDU.BookInventoryApp.dto.request;

public class BookSearchQueryRequest {

    private String name = "";
    private String authorName = "";

    private Double minPrice = 0.0;
    private Double maxPrice = Double.MAX_VALUE;

    public BookSearchQueryRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public String toString() {
        return "BookSearchQueryRequest{" +
                "name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                '}';
    }
}
