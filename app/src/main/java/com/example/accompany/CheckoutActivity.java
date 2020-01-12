package com.example.accompany;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity
{
    private ShoppingCart mCart;
    private Button mPlaceOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_checkout);
        setTitle("Checkout");
        mPlaceOrderButton = findViewById(R.id.place_order_btn);
        mPlaceOrderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                placeOrder();
            }
        });

        Log.d("CHEKCOUT", "Starting checkout");


        mCart = ShoppingCart.getInstance();

        int items = mCart.getItemCount();

        LinearLayout mLayout = (LinearLayout) findViewById(R.id.cart_view);
        LinearLayout mLayout2 = (LinearLayout) findViewById(R.id.price_view);

        for(int i =0; i<items; i++){
            Product p = mCart.getItemFromCart(i);
            String itemName = p.getMenuItem();
            double itemPrice = p.getPrice();
            final TextView textView = new TextView(this);
            final TextView textView2 = new TextView(this);
            textView.setText(itemName);
            textView2.setText(Double.toString(itemPrice));
            mLayout.addView(textView);
            mLayout2.addView(textView2);
        }



        TextView totalsExp = findViewById(R.id.totals_txt);
        totalsExp.setTextColor(Color.BLUE);
        // totals text
        TextView totalsVal = findViewById(R.id.totals_value);
        double total = mCart.calculateCartTotal();
        totalsVal.setText("$" + Double.toString(total));
        // tax
        TextView taxExp = findViewById(R.id.tax_txt);


        taxExp.setText("Tax: ");
        taxExp.setTextColor(Color.BLUE);
        TextView taxVal = findViewById(R.id.tax_value);
        // fees
        taxVal.setText("6%");
        TextView feeExp = findViewById(R.id.fees_txt);
        feeExp.setText("Fees: ");
        feeExp.setTextColor(Color.BLUE);
        TextView feeVal = findViewById(R.id.fees_value);
        feeVal.setText("$5.00");
        // grand total
        TextView grandExp = findViewById(R.id.grand_total_txt);
        grandExp.setText("TOTAL: ");
        grandExp.setTextColor(Color.BLUE);
        TextView grandVal = findViewById(R.id.grand_total_value);
        total += 5.00;
        grandVal.setText("$" + total);

        Log.d("CHECKOUT", String.valueOf(items));
    }

    public void placeOrder()
    {
        Log.d("INFO", "Place Order called...");

        AppDelivery delivery = new AppDelivery();
        delivery.setInstructions("In Airport Delivery");
        delivery.setConcessionName("Chick-Fil-A");
        delivery.setTotal(new BigDecimal(21.23));
        AppUser user = new AppUser("test", "404-218-4578", "knudmt@outlook.com", "Terminal B", "6", new BigDecimal(4.06));
        delivery.setUser(user);
        List<AppItems> items = new ArrayList<AppItems>();
        AppItems a = new AppItems("Chicken Sandwhich", new BigDecimal(4.45), 1);
        items.add(a);
        delivery.setItems(items);

        Log.d("INFO", "Delivery Item Created");
        try
        {
            Log.d("INFO", "Calling Azure Quote...");
            SwiftQuote quote = new SwiftQuote(this, delivery);
            String q = quote.getQuote();
            Log.d("QUOTE", q);
        }
        catch (Exception ex)
        {
            Log.d("ERR", ex.getMessage());
        }
    }
}
