package com.example.myshop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myshop.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class PersonalActivity extends AppCompatActivity {


    String username;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);


        Intent intent = getIntent();
        username = intent.getStringExtra("USERNAME_KEY");


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_Me);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId()==R.id.bottom_Me){
                return true ;
            } else if (item.getItemId()==R.id.bottom_ShoppingCart) {
                Intent intent1 = new Intent(PersonalActivity.this, ShoppingCartActivity.class);
                intent1.putExtra("USERNAME_KEY", username);
                startActivity(intent1);
                overridePendingTransition(0,0);
                finish();
                return true;
            } else if (item.getItemId()==R.id.bottom_Market) {
                Intent intent1 = new Intent(PersonalActivity.this, MainActivity.class);
                intent1.putExtra("USERNAME_KEY", username);
                startActivity(intent1);
                overridePendingTransition(0,0);
                finish();
                return true;
            }else{
                return false;
            }
        });
    }
}