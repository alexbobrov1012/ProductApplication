package com.example.productapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productapplication.data.Product;

import java.util.List;

public class ProductRecycleViewAdapter extends RecyclerView.Adapter<ProductRecycleViewHolder> {

    List<Product> productList;

    OnItemListClickListener listener;

    public ProductRecycleViewAdapter(OnItemListClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_view_item, parent, false);
        return new ProductRecycleViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductRecycleViewHolder holder, int position) {
        holder.bind(productList.get(position));
    }

    @Override
    public int getItemCount() {
        if (productList == null)
            return 0;
        return productList.size();
    }

    public void setProducts(List<Product> products) {
        this.productList = products;
        notifyDataSetChanged();
    }

    public Product getItemById(int id) {
        return productList.get(id);
    }

}
