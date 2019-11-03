package com.example.accompany;

import java.math.BigDecimal;

public class DeliveryBookingItemModel
{
    private int Quanity;
    private String Sku;
    private String Description;
    private BigDecimal Price;

    public int getQuanity(){
        return this.Quanity;
    }

    public void setQuanity(int quanity){
        this.Quanity = quanity;
    }

    public String getSku(){
        return this.Sku;
    }

    public void setSku(String sku){
        this.Sku = sku;
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
}
