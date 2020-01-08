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

    private String _url = "https://accompanyconcessions.azurewebsites.net/api/concessions?id=1";

    private String[] menus = { "loading..." };
    private MenuListAdapter adapter;
    private ListView listView;
    private JSONArray menuItems = new JSONArray();
    private String concessionName = "";
    private String mCurrentItem = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Chick-fil-a");
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

        StringRequest req = new StringRequest(Request.Method.GET, _url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("**RESPONSE**", response);

                try{

                    Log.d("PARSING", "attempting a parse");

                    response = response.replaceAll("[\\\\]{1}[\"]{1}", "\"");
                    response = response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1);

                    JSONObject obj = new JSONObject(response);
                    Log.d("PARSED!", "object has been parsed");

                    JSONObject menus = obj.getJSONObject("menus");
                    Log.d("MENUS", menus.toString());
                    JSONObject menu = menus.getJSONObject("menu");
                    Log.d("MENU", menu.toString());

                    concessionName = menu.getString("concessionName");

                    JSONArray categories = menu.getJSONArray("categories");

                    JSONObject entrees = categories.getJSONObject(0);
                    menuItems = entrees.getJSONArray("menuItems");

                    Log.d("LEN", String.valueOf(menuItems.length()));
                    // update the adapter
                    adapter.update(menuItems);
                    adapter.notifyDataSetChanged();


                }catch(Exception ex){
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
