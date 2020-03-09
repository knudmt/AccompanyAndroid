package com.example.accompany;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class UserInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        Bundle bundle = getIntent().getExtras();
        User usr = bundle.getParcelable("User");

        TextView firstName = findViewById(R.id.usrFname);
        firstName.setText("First Name : " + usr.getFirstName());

        TextView lastName = findViewById(R.id.usrLname);
        lastName.setText("Last Name :" + usr.getLastName());

        TextView id = findViewById(R.id.usrId);
        id.setText("Google ID : " + usr.getId());

        TextView isEnrolled = findViewById(R.id.isEnrolled);
        isEnrolled.setText("Is Enrolled : " + usr.getIsEnrolled());

        TextView phone = findViewById(R.id.phoneNumber);
        phone.setText("Phone : " + usr.getPhoneNumber());
    }
}
