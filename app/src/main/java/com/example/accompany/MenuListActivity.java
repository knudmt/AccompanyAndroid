package com.example.accompany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;



public class MenuListActivity extends AppCompatActivity {

    private String _url = "https://accompanyconcessions.azurewebsites.net/api/concessions?id=";

    private String[] menus = { "loading..." };
    private MenuListAdapter adapter;
    private ListView listView;
    private JSONArray menuItems = new JSONArray();
    private String concessionName = "";
    private String mCurrentItem = "";
    private String concessionId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        concessionId = getIntent().getStringExtra("ITEM_ID");

        /* this will need to be changed when we move to another airport. we will need to use lookup table in SQL & API call */
        switch (concessionId)
        {
            case "0":
                concessionId = "11";
                this.setTitle("Chick-Fil-A");
                break;

            case "1":
                concessionId = "6";
                this.setTitle("Pei Wei Asian Kitchen");
                break;

            case "2":
                concessionId = "7";
                this.setTitle("PDQ Chicken");
                break;

            case "3":
                concessionId = "8";
                this.setTitle("Starbucks");
                break;

            case "4":
                concessionId = "9";
                this.setTitle("Qdoba Mexican");
                break;
            case "5":
                concessionId = "10";
                this.setTitle("Wendy's");
                break;
        }

        setContentView(R.layout.activity_concession_view);
        getMenus();

        listView = findViewById(R.id.list_view_id);
        adapter = new MenuListAdapter(this, menuItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent itemDetailIntent = new Intent(MenuListActivity.this, MenuItemDetail.class);
                ItemDescription item = parseMenu(menuItems, i);

                itemDetailIntent.putExtra("Detail", item);
                itemDetailIntent.putExtra("Concession", concessionName);
                itemDetailIntent.putExtra("Name", mCurrentItem);
                startActivity(itemDetailIntent);
            }
        });
    }


    public void getMenus(){

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest req = new StringRequest(Request.Method.GET, _url + concessionId, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("**RESPONSE**", response);

                try{

                    Log.d("PARSING", "attempting a parse");
                    String temp = response;

                    temp = temp.replace("\\r\\n\\t", "");
                    temp = temp.replace("\\t", "");

                    temp = temp.replaceAll("[\\\\]{1}[\"]{1}", "\"");
                    temp = temp.replace("\\r", "");
                    temp = temp.replace("\\n", "");

                    temp = temp.substring(temp.indexOf("{"), temp.lastIndexOf("}") + 1);
                    Log.d("PSR", temp);

                    JSONObject obj = new JSONObject(temp);
                    Log.d("PARSED!", "object has been parsed");

                    JSONObject menus = obj.getJSONObject("menus");
                    Log.d("MENUS", menus.toString());
                    JSONObject menu = menus.getJSONObject("menu");
                    Log.d("MENU", menu.toString());

                    concessionName = menu.getString("concessionName");

                    JSONArray categories = menu.getJSONArray("categories");

                    int numOfCategories = categories.length();

                    for(int i = 0; i < numOfCategories; i++){
                        JSONObject entrees = categories.getJSONObject(i);
                        menuItems = entrees.getJSONArray("menuItems");
                        Log.d("LEN", String.valueOf(menuItems.length()));
                        // update the adapter
                        adapter.addMenuItems(menuItems);
                    }

                    adapter.notifyDataSetChanged();

                }
                catch(Exception ex){
                    Log.d("EX_ERR", ex.getMessage());
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


    public ItemDescription parseMenu(JSONArray items, int index)
    {
        try
        {
            JSONObject row = items.getJSONObject(index);
            mCurrentItem = row.getString("name");
            String description = row.getString("description");
            JSONArray subItems = row.getJSONArray("subItems");
            String price = subItems.getJSONObject(0).getString("price");

            return new ItemDescription(description, price);
        }
        catch (Exception ex)
        {
            Log.d("ERR", "Could not find item");
        }
        return null;
    }
}
