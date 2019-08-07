package com.example.productapplication.data.utils;

public enum BookContent {

    PROGRAMMING ("Программирование"),
    COOKING ("Кулинария"),
    ESOTERICS ("Изотерика");

    private String title;

    BookContent(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}