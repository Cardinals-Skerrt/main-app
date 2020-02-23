package com.cardinalskerrt.cultureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class LoginActivity extends AppCompatActivity {

    boolean isChecked = false;
    CheckBox artistBool;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        artistBool = findViewById(R.id.artistCheck);
        loginBtn = findViewById(R.id.btn_login);
        artistBool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isChecked){
                    isChecked = true;
                } else {
                    isChecked = false;
                }
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isChecked){
                    Intent intent = new Intent(LoginActivity.this, SellerScreenActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(LoginActivity.this, UserScreenActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
