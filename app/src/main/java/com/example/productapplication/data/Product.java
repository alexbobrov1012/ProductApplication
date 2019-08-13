package com.example.productapplication.data;

import com.example.productapplication.data.utils.ProductType;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private String name;

    private double price;

    private String code;

    private ProductType productType;

    public Product(String name, double price, String code, ProductType productType) {
        this.name = name;
        this.price = price;
        this.code = code;
        this.productType = productType;
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

    public ProductType getProductType() {
        return productType;
    }

    public String getInfo() {
        return "Имя: " + name + '\n' +
                "Цена: " + price + '\n' +
                "Штрих код: " + code + '\n';
    }

    public String getTitle() {
        return getName();
    }

    public abstract String getSubTitle();

}
