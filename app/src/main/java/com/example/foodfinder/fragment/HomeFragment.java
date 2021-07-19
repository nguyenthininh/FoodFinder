package com.example.foodfinder.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.foodfinder.R;
import com.example.foodfinder.adapter.CategoryAdapter;
import com.example.foodfinder.model.CategoryDomain;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recycleViewCategory();
        return view;
    }

    private void recycleViewCategory(){
        ArrayList<CategoryDomain> categoryDomains = new ArrayList<>();
        categoryDomains.add(new CategoryDomain("Xào",R.drawable.fried));
        categoryDomains.add(new CategoryDomain("Chiên",R.drawable.crispy));
        categoryDomains.add(new CategoryDomain("Nướng",R.drawable.grilled));
        categoryDomains.add(new CategoryDomain("Hấp",R.drawable.steamed));
        categoryDomains.add(new CategoryDomain("Luộc",R.drawable.boiled));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        adapter = new CategoryAdapter((Activity) getContext(),categoryDomains);
        if (getView() != null){
            recyclerViewCategoryList = getView().findViewById(R.id.rv_categories);
            recyclerViewCategoryList.setLayoutManager(linearLayoutManager);
            recyclerViewCategoryList.setAdapter(adapter);
        }

        adapter.notifyDataSetChanged();
    }
}