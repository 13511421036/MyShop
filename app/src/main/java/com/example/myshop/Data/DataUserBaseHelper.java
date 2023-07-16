package com.example.myshop.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataUserBaseHelper extends SQLiteOpenHelper {

    private static final String databaseName="Signup.db";

    public DataUserBaseHelper(@Nullable Context context) {
        super(context, "Signup.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table allusers(email Text primary key,password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int i, int i1) {
        MyDatabase.execSQL("drop Table if exists allusers");
    }

    public Boolean insertData(String email,String password){
        SQLiteDatabase MyDatabase=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result=MyDatabase.insert("allusers",null,contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }


    public Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase= this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email=?",new String[]{email});
        if(cursor.getCount()>0){
            return true;

        }else{
            return false;
        }
    }


    public Boolean checkEmailPassword(String email,String password){
        SQLiteDatabase MyDatabase= this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0){
            return true;

        }else{
            return false;
        }
    }
    public Boolean checkadmin(String email,String password){
        SQLiteDatabase MyDatabase= this.getWritableDatabase();
        if(!email.equals("admin")){
            return false;
        }
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public void delete(String email) {
        SQLiteDatabase MyDatabase= this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email=?",new String[]{email});
        if (cursor.getCount() > 0) {
            // 删除匹配的行数据
            MyDatabase.delete("allusers", "email=?", new String[]{email});
            cursor.close();
            MyDatabase.close();
        } else {
            cursor.close();
            MyDatabase.close();
        }
    }
}
