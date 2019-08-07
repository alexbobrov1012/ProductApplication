package com.example.productapplication;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.productapplication.data.Product;

public class AboutActivity extends AppCompatActivity {

    TextView aboutTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Intent intent = getIntent();
        Product productItem = (Product) intent.getSerializableExtra("product");

        getSupportActionBar().setTitle(productItem.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        aboutTextView = findViewById(R.id.aboutTextView);
        aboutTextView.setText(productItem.toString());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
