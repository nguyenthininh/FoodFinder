package com.example.foodfinder.adapter;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodfinder.R;
import com.example.foodfinder.model.CategoryDomain;

import java.time.Instant;
import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    Activity activity;
    ArrayList<CategoryDomain> categoryDomains;
    private Instant Glide;

    public CategoryAdapter(Activity activity, ArrayList<CategoryDomain> categoryDomains) {
        this.activity = activity;
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.fragment_item_category,parent,false);
        CategoryViewHolder holder;
        holder = new CategoryViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        CategoryViewHolder vh  = holder;
        CategoryDomain model = categoryDomains.get(position);
        vh.categoryName.setText(model.getTitle());
        vh.categoryImage.setImageResource(model.getImage());
    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryImage;
        ConstraintLayout mainLayout;

        public CategoryViewHolder(@NonNull  View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.tv_title_category);
            categoryImage = itemView.findViewById(R.id.img_cart);
            mainLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}
