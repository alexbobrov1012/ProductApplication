package com.example.productapplication.data.books;

import com.example.productapplication.data.Product;
import com.example.productapplication.data.ProductType;

public abstract class Book extends Product {
    int pages;

    private BookContent bookContent;

    public Book(String name, double price, String code, int pages, BookContent bookContent) {
        super(name, price, code, ProductType.BOOK);
        this.pages = pages;
        this.bookContent = bookContent;
    }

    public BookContent getBookContent() {
        return bookContent;
    }

    @Override
    public String getSubTitle() {
        return getBookContent().getTitle();
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                "Тип товара: " + ProductType.BOOK.getTitle() + '\n' +
                "Жанр: " + bookContent.getTitle() + '\n';
    }
}
