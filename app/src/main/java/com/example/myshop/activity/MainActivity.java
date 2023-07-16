package com.example.myshop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.myshop.R;
import com.example.myshop.discountActivity.BerryDiscountActivity;
import com.example.myshop.discountActivity.BroccoliDiscountActivity;
import com.example.myshop.discountActivity.MeatDiscountActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        username = intent.getStringExtra("USERNAME_KEY");

        //主页推荐


        //底部导航
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_Market);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId()==R.id.bottom_Market){
                return true ;
            } else if (item.getItemId()==R.id.bottom_ShoppingCart) {
                Intent intent1 = new Intent(MainActivity.this, ShoppingCartActivity.class);
                intent1.putExtra("USERNAME_KEY", username);
                startActivity(intent1);
                overridePendingTransition(0,0);
                finish();
                return true;
            } else if (item.getItemId()==R.id.bottom_Me) {
                Intent intent1 = new Intent(MainActivity.this, PersonalActivity.class);
                intent1.putExtra("USERNAME_KEY", username);
                startActivity(intent1);
                overridePendingTransition(0,0);
                finish();
                return true;
            }else{
                return false;
            }
        });

        //低价好物轮播
        ViewFlipper flipper1 = findViewById(R.id.flipper1);
        ViewFlipper flipper2 = findViewById(R.id.flipper2);

        flipper1.startFlipping();
        flipper2.startFlipping();

        ImageView back1=findViewById(R.id.main_back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("USERNAME_KEY", username);
                startActivity(intent);
            }
        });


        //低价好物点击
        ImageView flipper_imageView1=findViewById(R.id.flipper_imageView1);
        ImageView flipper_imageView2=findViewById(R.id.flipper_imageView2);
        ImageView flipper_imageView3=findViewById(R.id.flipper_imageView3);
        ImageView flipper_imageView7=findViewById(R.id.flipper_imageView7);
        ImageView flipper_imageView8=findViewById(R.id.flipper_imageView8);
        ImageView flipper_imageView9=findViewById(R.id.flipper_imageView9);
        flipper_imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MeatDiscountActivity.class);
                intent.putExtra("USERNAME_KEY", username);
                startActivity(intent);
            }
        });
        flipper_imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BerryDiscountActivity.class);
                intent.putExtra("USERNAME_KEY", username);
                startActivity(intent);
            }
        });
        flipper_imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BroccoliDiscountActivity.class);
                intent.putExtra("USERNAME_KEY", username);
                startActivity(intent);
            }
        });
        flipper_imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BerryDiscountActivity.class);
                intent.putExtra("USERNAME_KEY", username);
                startActivity(intent);
            }
        });
        flipper_imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BroccoliDiscountActivity.class);
                intent.putExtra("USERNAME_KEY", username);
                startActivity(intent);
            }
        });
        flipper_imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MeatDiscountActivity.class);
                intent.putExtra("USERNAME_KEY", username);
                startActivity(intent);
            }
        });

        //六分类点击
        ImageView tb1=findViewById(R.id.main_tb1);
        ImageView tb2=findViewById(R.id.main_tb2);
        ImageView tb3=findViewById(R.id.main_tb3);
        ImageView tb4=findViewById(R.id.main_tb4);
        ImageView tb5=findViewById(R.id.main_tb5);
        ImageView tb6=findViewById(R.id.main_tb6);
        tb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MeatDiscountActivity.class);
                intent.putExtra("USERNAME_KEY", username);
                startActivity(intent);
            }
        });
        tb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MeatDiscountActivity.class);
                intent.putExtra("USERNAME_KEY", username);
                startActivity(intent);
            }
        });
        tb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BerryDiscountActivity.class);
                intent.putExtra("USERNAME_KEY", username);
                startActivity(intent);
            }
        });
        tb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BerryDiscountActivity.class);
                intent.putExtra("USERNAME_KEY", username);
                startActivity(intent);
            }
        });
        tb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BroccoliDiscountActivity.class);
                intent.putExtra("USERNAME_KEY", username);
                startActivity(intent);
            }
        });
        tb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BroccoliDiscountActivity.class);
                intent.putExtra("USERNAME_KEY", username);
                startActivity(intent);
            }
        });


    }
}