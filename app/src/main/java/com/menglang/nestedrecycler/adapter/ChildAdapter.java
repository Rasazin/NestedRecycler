package com.menglang.nestedrecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.menglang.nestedrecyclerview.R;
import com.menglang.nestedrecyclerview.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {

    private List<Product> productList;

    public ChildAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.textView.setText(product.getTitle());

        // Load image from URL using Glide
        Glide.with(holder.imageView.getContext())
                .load(product.getImageUrl())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);

        Picasso.get()
                .load(product.getImageUrl())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ChildViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ChildViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageProduct);
            textView = itemView.findViewById(R.id.textProduct);
        }
    }
}

