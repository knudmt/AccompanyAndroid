package com.example.accompany;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import org.json.JSONObject;

public class SwiftQuote
{
    private String mApi = "api/public/v2/quotes?ApiKey=a6940c6c-4ef8-4fbd-b505-25838b94dba7";
    private MerchantDeliveryBookingModel mBooking;
    private Context mContext;

    public SwiftQuote(Context context, MerchantDeliveryBookingModel booking) throws Exception
    {
        if(booking == null){
            throw new Exception("Booking cannot be null");
        }
        if(context == null){
            throw new Exception("Context cannot be null");
        }
        mContext = context;
        mBooking = booking;
    }

    public String getQuote()
    {
        mBooking = TestDataCreator.CreateTestBooking();
        RequestQueue queue = Volley.newRequestQueue(mContext);
        JSONObject obj = parse();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, mApi, obj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("RESP", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERR", error.getMessage());
            }
        });
        queue.add(request);

        return "";
    }

    /*
    public String getQuote()
    {
        RequestQueue queue = Volley.newRequestQueue(mContext);
        StringRequest postRequest = new StringRequest(Request.Method.POST, mApi, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error.Response", error.getMessage());
            }
        })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<>();
                params.put("name", "matt");
                params.put("domain", "http");

                return params;
            }
        };
        queue.add(postRequest);

        return "";
    }
     */

    private JSONObject parse()
    {
        try
        {
            Gson gson = new Gson();
            String json = gson.toJson(mBooking);
            return new JSONObject(json);
        }
        catch (Exception ex)
        {
            Log.d("ERR", "Error parsing object");
        }
        return null;
    }
}
