package com.example.productapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productapplication.data.Product;
import com.example.productapplication.data.books.Book;
import com.example.productapplication.data.books.CookingBook;
import com.example.productapplication.data.books.EsotericsBook;
import com.example.productapplication.data.books.ProgrammingBook;
import com.example.productapplication.data.discs.CDDisc;
import com.example.productapplication.data.discs.DVDDisc;
import com.example.productapplication.data.discs.Disc;
import com.example.productapplication.data.utils.DiscContent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemListClickListener{

    private List<Product> products;

    private ProductRecycleViewAdapter adapter;

    private AppCompatSpinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initProducts();

        initRecycleView();

        initSpinner();
    }

    void initProducts() {
        products = new ArrayList<>();
        products.add(new ProgrammingBook("Философия Java", 500, "1234prog", 567, "Java"));
        products.add(new CookingBook("Борщи", 300, "12345cook", 324, "Свекла"));
        products.add(new EsotericsBook("Империя ангелов", 755, "12345eso", 56, 32));
        products.add(new CDDisc("Стас Михайлов", 250, "12346mus", DiscContent.MUSIC));
        products.add(new DVDDisc("Унесенные призраками", 500, "1234film", DiscContent.VIDEO));
    }

    void initRecycleView() {
        RecyclerView recyclerView = findViewById(R.id.productsRecycleView);
        adapter = new ProductRecycleViewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setProducts(products);
        adapter.notifyDataSetChanged();
    }

    void initSpinner() {
        spinner = findViewById(R.id.categorySpinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String [] categoryArray = getResources().getStringArray(R.array.productCategory);
                if (spinner.getSelectedItem().equals(categoryArray[0])) {
                    initProducts();
                    adapter.setProducts(products);
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

    void showBooksOnly() {
        initProducts();
        Iterator<Product> i = products.iterator();
        while (i.hasNext()) {
            Product s = i.next();
            if(s instanceof Disc)
                i.remove();
        }
        adapter.setProducts(products);
        adapter.notifyDataSetChanged();
    }

    void showDisksOnly() {
        initProducts();
        Iterator<Product> i = products.iterator();
        while (i.hasNext()) {
            Product s = i.next();
            if(s instanceof Book)
                i.remove();
        }
        adapter.setProducts(products);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemListClick(int adapterPosition) {
        Intent intent = new Intent(this, AboutActivity.class);
        intent.putExtra("product", adapter.getItemById(adapterPosition));
        startActivity(intent);
    }
}
