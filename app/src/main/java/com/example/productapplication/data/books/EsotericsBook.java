package com.example.productapplication.data.books;

public class EsotericsBook extends Book {
    private int minAge;

    public EsotericsBook(String name, double price, String code, int pages, int minAge) {
        super(name, price, code, pages, BookContent.ESOTERICS);
        this.minAge = minAge;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                "Возраст: " + minAge + '\n' +
                "Страницы: " + pages + '\n';
    }

}
