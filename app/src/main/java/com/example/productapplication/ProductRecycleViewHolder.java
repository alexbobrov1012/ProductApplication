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

    public void bind(Product product) {
        String title, subTitle = "";
        title = product.getName();
        if (product instanceof CookingBook)
            subTitle = BookContent.COOKING.getTitle();
        else if (product instanceof EsotericsBook)
            subTitle = BookContent.ESOTERICS.getTitle();
        else if (product instanceof ProgrammingBook)
            subTitle = BookContent.PROGRAMMING.getTitle();
        else if(product instanceof Disc)
            subTitle = ((Disc) product).getContent().getTitle();
        titleTextView.setText(title);
        subTitleTextView.setText(subTitle);
    }

    @Override
    public void onClick(View v) {
        listener.onItemListClick(getAdapterPosition());
    }
}
