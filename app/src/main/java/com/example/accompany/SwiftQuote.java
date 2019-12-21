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
    private String mApi = "https://accompanyorder.azurewebsites.net/api/Delivery";
    private AppDelivery mDelivery;
    private Context mContext;

    public SwiftQuote(Context context, AppDelivery delivery) throws Exception
    {
        if(delivery == null){
            throw new Exception("Booking cannot be null");
        }
        if(context == null){
            throw new Exception("Context cannot be null");
        }
        mContext = context;
        mDelivery = delivery;
    }

    public String getQuote()
    {
        RequestQueue queue = Volley.newRequestQueue(mContext);
        JSONObject obj = parse();
        Log.d("INFO", "attempting to get quote.");



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


    private JSONObject parse()
    {
        try
        {
            Gson gson = new Gson();
            String json = gson.toJson(mDelivery);
            Log.d("PARSE", json);

            return new JSONObject(json);
        }
        catch (Exception ex)
        {
            Log.d("ERR", "Error parsing object");
        }
        return null;
    }
}
