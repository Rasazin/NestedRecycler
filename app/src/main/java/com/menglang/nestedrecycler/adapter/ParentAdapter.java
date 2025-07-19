package com.menglang.nestedrecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.menglang.nestedrecyclerview.R;
import com.menglang.nestedrecyclerview.model.Category;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder> {

    private List<Category> categoryList;

    public ParentAdapter(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.categoryTitle.setText(category.getCategoryTitle());

        ChildAdapter childAdapter = new ChildAdapter(category.getProductList());
        holder.childRecyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        holder.childRecyclerView.setAdapter(childAdapter);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class ParentViewHolder extends RecyclerView.ViewHolder {
        TextView categoryTitle;
        RecyclerView childRecyclerView;

        public ParentViewHolder(View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.textCategoryTitle);
            childRecyclerView = itemView.findViewById(R.id.recyclerViewChild);
        }
    }
}

