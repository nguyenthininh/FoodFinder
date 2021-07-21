package com.example.foodfinder.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodfinder.R;
import com.example.foodfinder.adapter.CategoryAdapter;
import com.example.foodfinder.adapter.MaterialAdapter;
import com.example.foodfinder.adapter.PopularAdapter;
import com.example.foodfinder.model.CategoryDomain;
import com.example.foodfinder.model.FoodDomain;
import com.example.foodfinder.model.Material;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView.Adapter adapterCategory, adapterPopular,adapterMaterial;
    private RecyclerView recyclerViewCategoryList;
    private RecyclerView recycleViewPopularList;
    private RecyclerView recycleViewMaterialList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataCategory();
        initDataMaterial();
        initDataPopular();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerViewCategoryList(view);
        setRecycleViewMaterialList(view);
        setRecycleViewPopularList(view);
    }

    private void initDataCategory(){
        ArrayList<CategoryDomain> categoryDomains = new ArrayList<>();
        categoryDomains.add(new CategoryDomain("Xào",R.drawable.fried));
        categoryDomains.add(new CategoryDomain("Chiên",R.drawable.crispy));
        categoryDomains.add(new CategoryDomain("Nướng",R.drawable.grilled));
        categoryDomains.add(new CategoryDomain("Hấp",R.drawable.steamed));
        categoryDomains.add(new CategoryDomain("Luộc",R.drawable.boiled));
        adapterCategory = new CategoryAdapter(categoryDomains);
    }

    private void initDataPopular(){
        ArrayList<FoodDomain> foodDomains = new ArrayList<>();
        foodDomains.add(new FoodDomain("Fried Halloumi",R.drawable.fried_halloumi,"45.0"));
        foodDomains.add(new FoodDomain("Salad",R.drawable.salad,"40.0"));
        foodDomains.add(new FoodDomain("Rice",R.drawable.rice,"50.0"));
        foodDomains.add(new FoodDomain("Rice recipes",R.drawable.recipes,"80.0"));
        foodDomains.add(new FoodDomain("Rice erdnuss",R.drawable.erdnuss,"70.0"));
        adapterPopular = new PopularAdapter(foodDomains);
    }

    private void initDataMaterial(){
        ArrayList<Material> materials = new ArrayList<>();
        materials.add(new Material("Cà rốt", R.drawable.carrot));
        materials.add(new Material("Cải ngọt", R.drawable.spinach));
        materials.add(new Material("Xúp lơ", R.drawable.broccoli));
        materials.add(new Material("Cà tím", R.drawable.eggplant));
        materials.add(new Material("Khoai tây", R.drawable.potato));
        materials.add(new Material("Cà chua", R.drawable.tomato));
        materials.add(new Material("Bắp cải", R.drawable.cabbage));
        materials.add(new Material("Củ rau tím", R.drawable.beet));
        materials.add(new Material("Dưa chuột", R.drawable.cucumber));
        materials.add(new Material("Ớt chuông vàng", R.drawable.bell_pepper));
        adapterMaterial = new MaterialAdapter(materials);
    }

    private void setRecyclerViewCategoryList(View viewCategoryList){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = viewCategoryList.findViewById(R.id.rv_categories);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);
        recyclerViewCategoryList.setAdapter(adapterCategory);
    }

    private void setRecycleViewMaterialList(View viewMaterialList){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycleViewMaterialList = viewMaterialList.findViewById(R.id.rv_material);
        recycleViewMaterialList.setLayoutManager(linearLayoutManager);
        recycleViewMaterialList.setAdapter(adapterMaterial);
    }

    private void setRecycleViewPopularList(View viewPopularList){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycleViewPopularList = viewPopularList.findViewById(R.id.rv_popular);
        recycleViewPopularList.setLayoutManager(linearLayoutManager);
        recycleViewPopularList.setAdapter(adapterPopular);
    }



}