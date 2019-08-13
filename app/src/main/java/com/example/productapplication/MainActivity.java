package com.example.productapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productapplication.data.Product;
import com.example.productapplication.data.ProductType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemListClickListener{

    private List<Product> products;

    private ProductRecycleViewAdapter adapter;

    private AppCompatSpinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        products = new ArrayList<>();

        initRecycleView();

        initSpinner();
    }



    void initRecycleView() {
        RecyclerView recyclerView = findViewById(R.id.productsRecycleView);
        adapter = new ProductRecycleViewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        showAllProducts();
    }

    void initSpinner() {
        spinner = findViewById(R.id.categorySpinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String [] categoryArray = getResources().getStringArray(R.array.productCategory);
                if (spinner.getSelectedItem().equals(categoryArray[0])) {
                    showAllProducts();
                }
                else if(spinner.getSelectedItem().equals(categoryArray[1])) {
                    showBooksOnly();
                }
                else if(spinner.getSelectedItem().equals(categoryArray[2])) {
                    showDisksOnly();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    void showAllProducts() {
        adapter.setProducts(ProdApp.getAppInstance().getProductList());
    }
    void showBooksOnly() {
        products.clear();
        for(Product token : ProdApp.getAppInstance().getProductList()) {
            if(token.getProductType().equals(ProductType.BOOK)) {
                products.add(token);
            }
        }
        adapter.setProducts(products);
    }

    void showDisksOnly() {
        products.clear();
        for(Product token : ProdApp.getAppInstance().getProductList()) {
            if(token.getProductType().equals(ProductType.DISC)) {
                products.add(token);
            }
        }
        adapter.setProducts(products);
    }

    @Override
    public void onItemListClick(int adapterPosition) {
        Intent intent = new Intent(this, AboutActivity.class);
        intent.putExtra("productName", adapter.getItemById(adapterPosition).getName());
        intent.putExtra("productInfo", adapter.getItemById(adapterPosition).getInfo());
        startActivity(intent);
    }
}
