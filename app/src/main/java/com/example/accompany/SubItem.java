package com.example.accompany;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubItem
{
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("price")
    @Expose
    private String price;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPrice(){
        return this.price;
    }

    public void setPrice(String price){
        this.price = price;
    }
}
