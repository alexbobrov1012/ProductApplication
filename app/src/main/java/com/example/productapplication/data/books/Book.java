package com.example.productapplication.data.books;

import com.example.productapplication.data.Product;

public abstract class Book extends Product {
    int pages;

    public Book(String name, double price, String code, int pages) {
        super(name, price, code);
        this.pages = pages;
    }

}
