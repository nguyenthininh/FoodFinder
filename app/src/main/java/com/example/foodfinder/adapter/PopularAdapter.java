package com.example.foodfinder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.foodfinder.R;
import com.example.foodfinder.model.FoodDomain;
import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter {
    ArrayList<FoodDomain> foodDomains;

    public PopularAdapter(ArrayList<FoodDomain> foodDomains) {
        this.foodDomains = foodDomains;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater;
        inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.fragment_item_popular,parent,false);
        PopularViewHolder holder;
        holder = new PopularViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        PopularViewHolder vh = (PopularViewHolder) holder;
        FoodDomain model = foodDomains.get(position);
        vh.title.setText(model.getTitle());
        vh.price.setText(String.valueOf(model.getPrice()));
        vh.imageFood.setImageResource(model.getImage());
        vh.addFood.setOnClickListener(v -> {
        });
    }

    @Override
    public int getItemCount() {
        return foodDomains.size();
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder {
        TextView title, price;
        ImageView imageFood;
        TextView addFood;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_food);
            price = itemView.findViewById(R.id.tv_price);
            imageFood = itemView.findViewById(R.id.img_food);
            addFood = itemView.findViewById(R.id.tv_add_cart);
        }
    }


}