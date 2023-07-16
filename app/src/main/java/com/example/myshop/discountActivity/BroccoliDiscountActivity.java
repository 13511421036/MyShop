package com.example.myshop.discountActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myshop.Data.ShoppingCartData;
import com.example.myshop.R;
import com.example.myshop.activity.MainActivity;
import com.example.myshop.activity.PersonalActivity;
import com.example.myshop.activity.ShoppingCartActivity;
import com.example.myshop.databinding.ActivityBrocoliDicountBinding;
import com.example.myshop.pay.PayActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BroccoliDiscountActivity extends AppCompatActivity {


    ActivityBrocoliDicountBinding binding;
    ShoppingCartData shoppingCartData;

    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBrocoliDicountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupToolBar();


        Intent intent = getIntent();
        if(username==null) username = intent.getStringExtra("USERNAME_KEY");
        shoppingCartData =new ShoppingCartData(this,username);

        binding.broccoliCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoppingCartData.insertData("broccoli",25,1);
                Toast.makeText(BroccoliDiscountActivity.this,"加入购物车成功！",Toast.LENGTH_SHORT).show();
            }
        });
        binding.buybroccolinow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), PayActivity.class);
                startActivity(intent);
            }
        });







        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_Market);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId()==R.id.bottom_Market){
                Intent intent1 = new Intent(BroccoliDiscountActivity.this, MainActivity.class);
                intent1.putExtra("USERNAME_KEY", username);
                startActivity(intent1);
                overridePendingTransition(0,0);
                finish();
                return true ;
            } else if (item.getItemId()==R.id.bottom_ShoppingCart) {
                Intent intent1 = new Intent(BroccoliDiscountActivity.this, ShoppingCartActivity.class);
                intent1.putExtra("USERNAME_KEY", username);
                startActivity(intent1);
                overridePendingTransition(0,0);
                finish();
                return true;
            } else if (item.getItemId()==R.id.bottom_Me) {
                Intent intent1 = new Intent(BroccoliDiscountActivity.this, PersonalActivity.class);
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

    protected void setupToolBar() {
        Toolbar toolbar=findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}