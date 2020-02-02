package com.example.accompany;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class MenuListAdapter extends BaseAdapter {

    private Context context;
    private JSONArray menuItems;

    public MenuListAdapter(Context context, JSONArray menuItems){
        this.menuItems = menuItems;
        this.context = context;
    }

    @Override
    public int getCount(){

        return this.menuItems.length();
    }

    @Override
    public JSONObject getItem(int pos){

        try {
            return menuItems.getJSONObject(pos);

        }catch (JSONException ex){
            Log.d("EX", ex.getMessage());
        }
        return null;
    }

    @Override
    public long getItemId(int pos){
        return 0;
    }

    public void update(JSONArray menu){
        this.menuItems = menu;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){


        View rowView = View.inflate(context, R.layout.listview_row, null);
        TextView txtView = rowView.findViewById(R.id.txt_name);
        TextView descView = rowView.findViewById(R.id.txt_desc);


        // get the 'Entrees'

        try {
            // set the text gets complicated
            txtView.setText(menuItems.getJSONObject(position).getString("name"));
            descView.setText(menuItems.getJSONObject(position).getString("description"));
        }catch (JSONException ex){
            Log.d("PARSE_ERROR", ex.getMessage());
        }

        return rowView;
    }
}
