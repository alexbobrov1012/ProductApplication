package com.example.productapplication.data.utils;

public enum  DiscType {
    DVD("DVD"),
    CD("CD");

    private String title;

    DiscType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
