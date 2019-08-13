package com.example.productapplication.data.discs;

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
