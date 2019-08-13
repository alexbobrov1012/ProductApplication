package com.example.productapplication.data.books;

public class ProgrammingBook extends Book {
    private String language;

    public ProgrammingBook(String name, double price, String code, int pages, String language) {
        super(name, price, code, pages, BookContent.PROGRAMMING);
        this.language = language;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                "Язык: " + language + '\n' +
                "Страницы: " + pages + '\n';
    }

}
