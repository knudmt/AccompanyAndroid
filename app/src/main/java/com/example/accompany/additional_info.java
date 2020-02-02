package com.example.accompany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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

    public void apiInfo(View view){
        EditText weight = (EditText) findViewById(R.id.editText4);
        EditText height = (EditText) findViewById(R.id.editText6);
        EditText email = (EditText) findViewById(R.id.editText7);
        String weightStr = weight.getText().toString();
        String heightStr = height.getText().toString();
        String emailStr = email.getText().toString();
        int weightint=Integer.parseInt(weightStr);


        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://accompanyuserinfoapi.azurewebsites.net/api/info";
        JSONObject postparams = new JSONObject();
        try {
            postparams.put("userEmail", emailStr);
            postparams.put("userWeight", weightint);
            postparams.put("userHeight", heightStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }




        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, postparams,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Success", "do something");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Failure Callback
                        Log.i("Fail", "do something else");
                    }
                })
        {
            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response){
                if ((response.statusCode == 201) && (response.data == null || response.data.length == 0)){
                    return Response.success(null, HttpHeaderParser.parseCacheHeaders(response));
                }else{
                    return super.parseNetworkResponse(response);
                }
            }

        };


// Adding the request to the queue along with a unique string tag
        queue.add(jsonObjReq);
    }


}
