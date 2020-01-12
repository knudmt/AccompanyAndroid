package com.example.accompany;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;


public class ConcessionListView extends AppCompatActivity
{
    private ListView listView;
    private Integer[] logos = { R.drawable.dd_logo, R.drawable.starbucks_logo, R.drawable.mc_logo };
    private String _url = "https://accompanyconcessions.azurewebsites.net/api/restaurants?city=Tampa";
    private String[] restaurants = {"Loading..."};
    private ConcessionAdapterB adapterB;
    private ArrayList<String> restaurantsArrayList;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        this.setTitle("Concession List");
        setContentView(R.layout.activity_concession_list_view);
        getData();


        listView = findViewById(R.id.concession_list);
        adapterB = new ConcessionAdapterB(this, restaurants);
        listView.setAdapter(adapterB);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent itemListIntent = new Intent(ConcessionListView.this, MenuListActivity.class);
                startActivity(itemListIntent);
            }
        });

        final EditText inputSearch = (EditText) findViewById(R.id.inputSearch);

        inputSearch.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {
                   String charText = inputSearch.getText().toString().trim().toLowerCase();
                   if (charText.length() == 0) {
                       int sz = restaurantsArrayList.size();
                       restaurants = new String [sz];
                       for (int i=0; i<sz; i++ ) {
                           restaurants [i] = restaurantsArrayList.get(i);
                       }
                   } else {
                       ArrayList <String> newRestaurantArrayList = new ArrayList<String>();
                       for (String restaurant : restaurantsArrayList) {
                           if (restaurant.toLowerCase().contains(charText)) {
                               newRestaurantArrayList.add(restaurant);
                           }
                       }
                       int sz = newRestaurantArrayList.size();
                       restaurants = new String [sz];
                       for (int i=0; i<sz; i++ ) {
                           restaurants[i] = newRestaurantArrayList.get(i);
                       }
                   }
                   adapterB.update(restaurants);

               }

               @Override
               public void afterTextChanged(Editable s) {

               }
           }
        );


    }


    private String[] jsonArrayToStringArray(JSONArray jsonArray){

        String[] strArray = new String[jsonArray.length()];

        try{
            for(int i = 0; i < jsonArray.length(); i++)
            {
                String str = jsonArray.getString(i);
                strArray[i] = str;
            }
        }catch (JSONException jex){
            Log.d("JSON_ERROR", jex.getMessage());
            return strArray;
        }

        return strArray;
    }

    private JSONArray parseObject(String jsonStr){

        jsonStr = jsonStr.replaceAll("[\\\\]{1}[\"]{1}", "\"");
        jsonStr = jsonStr.substring(jsonStr.indexOf("{"), jsonStr.lastIndexOf("}") + 1);

        try{
            JSONObject obj = new JSONObject(jsonStr);
            return obj.getJSONArray("concessions");

        }catch (JSONException jex){
            Log.d("JSON_ERR", jex.getMessage());
        }
        return null;
    }


    public void getData(){

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest req = new StringRequest(Request.Method.GET, _url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("RESP", response);
                try{

                    JSONArray arr = parseObject(response);

                    String[] d = jsonArrayToStringArray(arr);
                    restaurants = new String[d.length];

                    for(int i = 0; i < d.length; i++)
                    {
                        Log.d("ADD", "adding: " + d[i]);
                        restaurants[i] = d[i];
                    }

                    // save a copy of restaurants in restaurantsArrayList

                    restaurantsArrayList = new ArrayList<String>();
                    restaurantsArrayList.addAll(Arrays.asList(restaurants));
                    
                    // load view here
                    //adapter.notifyDataSetChanged();
                    adapterB.update(restaurants);
                    adapterB.notifyDataSetChanged();

                }catch (Exception ex){
                    Log.d("ERROR", ex.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERR", error.getMessage());
            }
        });

        queue.add(req);
    }

    public void getInfo(View view) {
        Intent intent = new Intent(this, additional_info.class);
        startActivity(intent);
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, ConcessionListView.class);
        startActivity(intent);
    }

    public void goToShoppingCart(View view) {
        Intent intent = new Intent(this, CheckoutActivity.class);
        startActivity(intent);
    }

}
