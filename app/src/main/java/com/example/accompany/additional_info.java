package com.example.accompany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class additional_info extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.accompany.MESSAGE";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_additional_info);
        EditText weight = (EditText) findViewById(R.id.editText4);
        weight.setFilters(new InputFilter[]{new InputFilterMinMax("1","999")});
        EditText height = (EditText) findViewById(R.id.editText6);
        height.setFilters(new InputFilter[]{new InputFilterMinMaxFloat("1.0","9.9")});
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, additional_info_display.class);
        Bundle extras = new Bundle();
        EditText weight = (EditText) findViewById(R.id.editText4);
        EditText height = (EditText) findViewById(R.id.editText6);
        EditText email = (EditText) findViewById(R.id.editText7);
        String weightStr = weight.getText().toString();
        String heightStr = height.getText().toString();
        String emailStr = email.getText().toString();
        if(emailStr.isEmpty()) {
            Toast.makeText(getApplicationContext(),"enter email address",Toast.LENGTH_SHORT).show();
        }else {
            if (emailStr.trim().matches(emailPattern)) {
                extras.putString("Weight", weightStr);
                extras.putString("Height", heightStr);
                extras.putString("Email", emailStr);
                intent.putExtras(extras);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
