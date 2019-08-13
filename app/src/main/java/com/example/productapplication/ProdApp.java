package com.example.productapplication;

import android.app.Application;

import com.example.productapplication.data.Product;
import com.example.productapplication.data.books.CookingBook;
import com.example.productapplication.data.books.EsotericsBook;
import com.example.productapplication.data.books.ProgrammingBook;
import com.example.productapplication.data.discs.Disc;
import com.example.productapplication.data.utils.DiscContent;
import com.example.productapplication.data.utils.DiscType;

import java.util.ArrayList;
import java.util.List;

public class ProdApp extends Application {
    private List<Product> productList;

    private static ProdApp appInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
        initProducts();
    }

    public static ProdApp getAppInstance() {
        return appInstance;
    }

    void initProducts() {
        productList = new ArrayList<>();
        productList.add(new ProgrammingBook("Философия Java", 500, "1234prog", 567, "Java"));
        productList.add(new CookingBook("Борщи", 300, "12345cook", 324, "Свекла"));
        productList.add(new EsotericsBook("Империя ангелов", 755, "12345eso", 56, 32));
        productList.add(new Disc("Стас Михайлов", 250, "12346mus", DiscType.CD,  DiscContent.MUSIC));
        productList.add(new Disc("Унесенные призраками", 500, "1234film",DiscType.DVD, DiscContent.VIDEO));
    }

    public List<Product> getProductList() {
        return productList;
    }
}
