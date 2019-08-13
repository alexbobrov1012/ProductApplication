package com.example.productapplication.data.books;

import com.example.productapplication.data.utils.BookContent;

public class CookingBook extends Book {
    private String ingredient;

    public CookingBook(String name, double price, String code, int pages, String ingredient) {
        super(name, price, code, pages, BookContent.COOKING);
        this.ingredient = ingredient;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                "Ингредиент: " + ingredient + '\n' +
                "Страницы: " + pages + '\n';
    }


}
