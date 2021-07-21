package com.example.foodfinder.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.foodfinder.Activity.LoginActivity;
import com.example.foodfinder.R;


public class ProfileFragment extends Fragment {
    public static final String SHARE_PREF_NAME = "useFile";
    public static final String KEY_ACTIVE = "active";
    private Button btLogout;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        btLogout = view.findViewById(R.id.btn_logout);
        btLogout.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "Logout success !", Toast.LENGTH_SHORT).show();
            logout();
            startActivity(new Intent(getActivity(), LoginActivity.class));
        });
        return view;
    }

    public void logout() {
        if (getActivity() != null) {
            sharedPreferences = getActivity().getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
        }
        editor = sharedPreferences.edit();
        editor.putBoolean(KEY_ACTIVE, false);
        editor.apply();
    }
}