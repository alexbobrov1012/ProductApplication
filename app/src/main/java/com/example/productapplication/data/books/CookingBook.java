package com.example.productapplication.data.books;

public class CookingBook extends Book {
    private String ingredient;

    public CookingBook(String name, double price, String code, int pages, String ingredient) {
        super(name, price, code, pages);
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Ингредиент = " + ingredient + '\n' +
                "Страницы =" + pages + '\n';
    }
}
