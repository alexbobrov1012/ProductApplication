package com.example.productapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productapplication.data.Product;
import com.example.productapplication.data.books.Book;
import com.example.productapplication.data.books.CookingBook;
import com.example.productapplication.data.books.EsotericsBook;
import com.example.productapplication.data.books.ProgrammingBook;
import com.example.productapplication.data.discs.Disc;
import com.example.productapplication.data.utils.BookContent;

public class ProductRecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView titleTextView;

    TextView subTitleTextView;

    OnItemListClickListener listener;

    public ProductRecycleViewHolder(@NonNull View itemView, OnItemListClickListener listener) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.titleTextView);
        subTitleTextView = itemView.findViewById(R.id.subTitleTextView);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void bind(String title, String subtitle) {
        titleTextView.setText(title);
        subTitleTextView.setText(subtitle);
    }

    @Override
    public void onClick(View v) {
        listener.onItemListClick(getAdapterPosition());
    }
}
