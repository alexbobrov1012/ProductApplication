package com.example.productapplication.data;

public enum ProductType {
    BOOK("Книга"),
    DISC("Диск");

    private String title;

    ProductType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
