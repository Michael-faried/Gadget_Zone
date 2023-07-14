package com.example.storeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class ProductDbHelper extends SQLiteOpenHelper {

    private static String DATABASENAME  = "Products_Database";
    SQLiteDatabase Products_Database;

    public ProductDbHelper(Context context){
        super(context,DATABASENAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PRODUCTS_TABLE(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT NOT NULL,DESCRIPTION TEXT ," +
                "Image BLOB NOT NULL ,PRICE FLOAT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PRODUCTS_TABLE");
        onCreate(db);
    }

    public Cursor fetchAllProducts(){
        String[] columns = {"ID","NAME","DESCRIPTION","PRICE"};
        Products_Database = getReadableDatabase();
        Cursor cursor = Products_Database.query("PRODUCTS_TABLE",columns,null,null,null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        Products_Database.close();
        return cursor;
    }

    public void insertProduct(int ID, byte[] img, String Name, String Description, float price){
        ContentValues row = new ContentValues();
        row.put("ID",ID);
        row.put("NAME",Name);
        row.put("DESCRIPTION",Description);
        row.put("Image",img);
        row.put("PRICE",price);
        Products_Database = getWritableDatabase();
        Products_Database.insert("PRODUCTS_TABLE",null,row);
        Products_Database.close();
    }

    public void deleteProduct(int ID){
        Products_Database = getWritableDatabase();
        Products_Database.delete("PRODUCTS_TABLE","ID='" + String.valueOf(ID) + "'",null);
        Products_Database.close();
    }


}
