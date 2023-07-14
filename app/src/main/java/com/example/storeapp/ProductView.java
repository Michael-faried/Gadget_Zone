package com.example.storeapp;

import android.media.Image;
import android.widget.Button;
import android.widget.ImageView;

public class ProductView {
    private int ID;
    private ImageView image;
    private String Name;
    private String Description;
    private float price;


    public ProductView(int ID,ImageView image,String Name,String Description,float price){
        this.ID = ID;
        this.image = image;
        this.Name = Name;
        this.Description = Description;
        this.price = price;
    }
}
