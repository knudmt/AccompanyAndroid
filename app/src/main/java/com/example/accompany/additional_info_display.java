package com.example.accompany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class additional_info_display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_info_display);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String weight = extras.getString("Weight");
        String height = extras.getString("Height");
        String email = extras.getString("Email");

        // Capture the layout's TextView and set the string as its text
        TextView textView1 = findViewById(R.id.textView2);
        textView1.setText(weight);
        TextView textView2 = findViewById(R.id.textView7);
        textView2.setText(height);
        TextView textView3 = findViewById(R.id.textView8);
        textView3.setText(email);
    }
}
