package com.example.productapplication.data.discs;

import com.example.productapplication.data.Product;
import com.example.productapplication.data.utils.DiscContent;

public abstract class Disc extends Product {
    private DiscContent content;
    public Disc(String name, double price, String code, DiscContent content) {
        super(name, price, code);
        this.content = content;
    }

    public DiscContent getContent() {
        return content;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Содержимое = " + content.toString();
    }
}
