package com.example.accompany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuItemDetail extends AppCompatActivity
{
    private ShoppingCart cart;
    private String mConcessionName = "";
    private String mItemName;
    private String mPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item_detail);

        cart = ShoppingCart.getInstance();
        cart.Init(getApplicationContext());

        Intent current = getIntent();
        ItemDescription item = current.getParcelableExtra("Detail");
        String description = item.getDescription();
        mPrice = item.getPrice();
        mPrice = mPrice.replace("$", "");

        mConcessionName = current.getStringExtra("Concession");
        mItemName = current.getStringExtra("Name");

        // combine the item and price here
        TextView dets = findViewById(R.id.desc_area);
        dets.setText(description);

        // TODO
        // 1. Combine the description text and the price from the parceable object that comes through
        // 2. Pass in the concession name (eg. chick-fil-a) when creating the view
        // 3. Make adjustment to the 'Project.java'
        // 4. Update the totals
        // 5. 3rd party integration!
    }


    private void showToast(String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void AddToCart(View view)
    {
        cart.addItemToCart(new Product(mConcessionName, mItemName, Double.parseDouble(mPrice)));
        Log.d("ADDING", "item: " + mItemName + " price: " + mPrice + " cart amount: " + cart.getItemCount());

        String msg = "Added: " + cart.getItemFromCart(cart.getItemCount() - 1).getMenuItem() + " to cart";
        showToast(msg);
    }

    public void checkout(View view)
    {
        // shoudl have access to the shopping cart
        startActivity(new Intent(MenuItemDetail.this, CheckoutActivity.class));
    }
}