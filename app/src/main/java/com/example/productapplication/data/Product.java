package com.example.productapplication.data;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private String name;

    private double price;

    private String code;

    public Product(String name, double price, String code) {
        this.name = name;
        this.price = price;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Имя = " + name + '\n' +
                "Цена = " + price + '\n' +
                "Штрих код = " + code + '\n'
                ;
    }
}
