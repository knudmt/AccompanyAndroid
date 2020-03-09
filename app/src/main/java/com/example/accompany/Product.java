package com.example.accompany;

public class Product
{
    private Concession mConcession;
    private double mPrice;
    private String mMenuItem;

    /**
     * Copy constructor
     * @param concessionName
     * @param item
     * @param price
     */
    public Product(String concessionName, String item, double price){
        this.setConcession(concessionName);
        this.mMenuItem = item;
        this.mPrice = price;
    }

    public String getMenuItem(){
        return this.mMenuItem;
    }

    public void setMenuItem(String menuItem){
        this.mMenuItem = menuItem;
    }

    public double getPrice(){
        return this.mPrice;
    }

    public void setPrice(double price){
        this.mPrice = price;
    }

    public Concession getConcession(){
        return this.mConcession;
    }

    public void setConcession(String name){
        this.mConcession = new Concession();
        this.mConcession.setName(name);
    }
}

