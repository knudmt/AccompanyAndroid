package com.example.accompany;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class AppItems
{
    @SerializedName("Description")
    @Expose
    private String Description;

    @SerializedName("Price")
    @Expose
    private BigDecimal Price;

    @SerializedName("Quanity")
    @Expose
    private int Quanity;

    public AppItems(String description, BigDecimal price, int quanity){
        this.Description = description;
        this.Price = price;
        this.Quanity = quanity;
    }

    public String getDescription(){
        return this.Description;
    }

    public void setDescription(String description){
        this.Description = description;
    }

    public BigDecimal getPrice(){
        return this.Price;
    }

    public void setPrice(BigDecimal price){
        this.Price = price;
    }

    public int getQunity(){
        return this.Quanity;
    }

    public void setQuanity(int quanity){
        this.Quanity = quanity;
    }
}
