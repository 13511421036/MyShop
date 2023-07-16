package com.example.myshop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.myshop.Data.ShoppingCartData;
import com.example.myshop.Data.myItem;
import com.example.myshop.R;
import com.example.myshop.mylistview.mycartlistview;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity {

    String username;
    ShoppingCartData shoppingCartData;

    ListView myListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        Intent intent = getIntent();
        username = intent.getStringExtra("USERNAME_KEY");


        myListView=findViewById(R.id.my_listview);

        List<myItem> myItemList=findAll();
        mycartlistview MYcarlistview=new mycartlistview(getApplicationContext(),myItemList,username);
        myListView.setAdapter(MYcarlistview);

        //导航栏
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_ShoppingCart);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId()==R.id.bottom_ShoppingCart){
                return true ;
            } else if (item.getItemId()==R.id.bottom_Market) {

                Intent intent1 = new Intent(ShoppingCartActivity.this, MainActivity.class);
                intent1.putExtra("USERNAME_KEY", username);
                startActivity(intent1);
                overridePendingTransition(0,0);
                finish();
                return true;
            } else if (item.getItemId()==R.id.bottom_Me) {
                Intent intent1 = new Intent(ShoppingCartActivity.this, PersonalActivity.class);
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
    public List<myItem> findAll(){
        shoppingCartData=new ShoppingCartData(this,username);
        shoppingCartData.isTableExists();
        SQLiteDatabase  db= shoppingCartData.getWritableDatabase();
        Cursor cursor =db.query(username,new String[]{"productName","price","number"},null,null,null,null,null);
        List <myItem> myItemList=new ArrayList<>();
        while (cursor.moveToNext()){
            myItem myitem=new myItem();
            myitem.setProductName(cursor.getString(0));
            myitem.setPrice(cursor.getInt(1));
            myitem.setNumber(cursor.getInt(2));
            myItemList.add(myitem);
        }
        db.close();
        return myItemList;
    }
}