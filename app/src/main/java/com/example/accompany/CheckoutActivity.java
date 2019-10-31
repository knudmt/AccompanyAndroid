package com.example.accompany;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity
{
    private ShoppingCart mCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        setTitle("Checkout");

        Log.d("CHEKCOUT", "Starting checkout");


        mCart = ShoppingCart.getInstance();

        int items = mCart.getItemCount();
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
}
