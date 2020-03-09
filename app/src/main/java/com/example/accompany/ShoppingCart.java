package com.example.accompany;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;

public class ShoppingCart
{
    private Context appContext;
    private static final ShoppingCart myCart = new ShoppingCart();

    private Product mProduct;
    private ArrayList<Product> mProducts;

    public ShoppingCart()
    {
        this.mProducts = new ArrayList<>();
    }

    public void Init(Context context){
        if(appContext == null){
            this.appContext = context;
        }
    }

    public static Context get(){
        return getInstance().getContext();
    }

    public static synchronized ShoppingCart getInstance(){
        return myCart;
    }

    private Context getContext(){
        return appContext;
    }

    public ShoppingCart(ArrayList<Product> products){
        this.mProducts = products;
    }


    public Product getItemFromCart(int position){
        if(!this.mProducts.isEmpty()){
            return this.mProducts.get(position);
        }
        return null;
    }

    public boolean addItemToCart(Product product){
        if(product != null)
        {
            this.mProducts.add(product);
            Log.d("CART", "Added new product to cart");
            return true;
        }
        return false;
    }

    public double calculateCartTotal(){
        double total = 0;
        if(!this.mProducts.isEmpty()){
            for(int i = 0; i < this.mProducts.size(); i++){
                total += this.mProducts.get(i).getPrice();
            }
        }
        return total;
    }

    public int getItemCount(){
        return this.mProducts.size();
    }
}
