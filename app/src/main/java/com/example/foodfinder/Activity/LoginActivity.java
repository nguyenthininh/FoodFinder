package com.example.foodfinder.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodfinder.R;

public class LoginActivity extends AppCompatActivity {
    public static final String PHONE = "0123456";
    public static final String PASSWORD = "123";
    public static final String SHARE_PREF_NAME = "useFile";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_PASSWORD = "pass";
    public static final String KEY_ACTIVE = "active";
    private Button btLogin;
    private EditText inputPhone, inputPassword;
    private String phoneNumber, passWord;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputPhone = findViewById(R.id.input_phone);
        inputPassword = findViewById(R.id.input_pass);
        btLogin = findViewById(R.id.btn_login);
        if (getStateLogin()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
            return;
        }
        initUI();
    }

    public boolean getStateLogin() {
        SharedPreferences sharedPreferences = getSharedPrefe    rences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(KEY_ACTIVE, false);
    }

    public void initUI() {
        btLogin.setOnClickListener(v -> {
            phoneNumber = inputPhone.getText().toString();
            passWord = inputPassword.getText().toString();
            validateCredentials(phoneNumber, passWord);
        });
    }

    private void usingPreferences() {
        sharedPreferences = getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(KEY_PHONE, PHONE);
        editor.putString(KEY_PASSWORD, PASSWORD);
        editor.putBoolean(KEY_ACTIVE, true);
        editor.commit();
    }

    private void validateCredentials(String inputPhone, String inputPassword) {
        if (inputPhone.equals(PHONE) && inputPassword.equals(PASSWORD)) {
            usingPreferences();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            showToastMessage("Failed to login with phone number:" + inputPhone);
        }
    }

    private void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}