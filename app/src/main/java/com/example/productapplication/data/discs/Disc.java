package com.example.productapplication.data.discs;

import com.example.productapplication.data.Product;
import com.example.productapplication.data.utils.DiscContent;
import com.example.productapplication.data.utils.DiscType;
import com.example.productapplication.data.utils.ProductType;

public class Disc extends Product {
    private DiscType type;

    private DiscContent content;

    public Disc(String name, double price, String code, DiscType type, DiscContent content) {
        super(name, price, code, ProductType.DISC);
        this.content = content;
        this.type = type;
    }

    public DiscContent getContent() {
        return content;
    }

    public DiscType getType() {
        return type;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                "Тип товара: " + getProductType().getTitle() + '\n' +
                "Содержимое: " + getContent().getTitle() + '\n' +
                "Тип диска: " + getType().getTitle() + '\n';
    }

    @Override
    public String getSubTitle() {
        return getContent().getTitle();
    }
}
