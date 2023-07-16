package com.example.myshop.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ShoppingCartData extends SQLiteOpenHelper {

    private static final String databaseName="ShoppingCart.db";
    public String username;

    public ShoppingCartData(@Nullable Context context,String username) {
        super(context, databaseName, null, 1);
        this.username=username;
    }

    //所有人用同一张表？

    @Override
    public void onCreate(SQLiteDatabase shopDatabase) {
        String createTableQuery = "create Table " + username + "(productName TEXT primary key, price Integer, number INTEGER)";
        shopDatabase.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase shopDatabase, int i, int i1) {
        String dropQuery="drop Table if exists "+username;
        shopDatabase.execSQL(dropQuery);
    }
    public SQLiteDatabase isTableExists() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name=?", new String[]{username});
        boolean exists = cursor.moveToFirst();
        if(!exists){
            String createTableQuery = "create Table " + username + "(productName TEXT primary key, price DECIMAL, number INTEGER)";
            db.execSQL(createTableQuery);
        }
        cursor.close();
        return db;
    }


    public void insertData(String productName, Integer price, Integer number) {
        SQLiteDatabase shopDatabase = this.isTableExists();
        String nextlineQuery="Select * from "+username+" where productName=?";
        Cursor cursor = shopDatabase.rawQuery(nextlineQuery, new String[]{productName});

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            int column=cursor.getColumnIndex("number");
            int existingNumber = cursor.getInt(column);
            int updatedNumber = existingNumber + number;

            ContentValues contentValues = new ContentValues();
            contentValues.put("number", updatedNumber);

            shopDatabase.update(username, contentValues, "productName=?", new String[]{productName});
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("productName", productName);
            contentValues.put("price", price);
            contentValues.put("number", number);

            shopDatabase.insert(username, null, contentValues);
        }

        cursor.close();
        shopDatabase.close();
    }

    public void deleteData(String productName, Integer price, Integer number) {
        SQLiteDatabase shopDatabase = this.getWritableDatabase();
        String nextlineQuery="SELECT * FROM "+username+" WHERE productName=?";
        Cursor cursor = shopDatabase.rawQuery(nextlineQuery, new String[]{productName});

        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                int column = cursor.getColumnIndex("number");
                int existingNumber = cursor.getInt(column);
                int updatedNumber = existingNumber - number;
                //小于零处理
                if (updatedNumber <= 0) {
                    // 删除行
                    shopDatabase.delete(username, "productName=?", new String[]{productName});
                } else {
                    // 更新表
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("number", updatedNumber);

                    shopDatabase.update(username, contentValues, "productName=?", new String[]{productName});
                }
            }
        }
        cursor.close();
    }
}
