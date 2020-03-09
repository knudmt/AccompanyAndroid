package com.example.accompany;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ConcessionListViewAdapter extends ArrayAdapter
{
    private final Activity context; // ref to the activity
    private final String[] menuItemArray;
    private final String[] menuDescArray;

    public ConcessionListViewAdapter(Activity context, String[] menuArrayParam, String[] descArrayParam)
    {
        super(context, R.layout.listview_row, menuArrayParam);
        this.context = context;
        this.menuDescArray = descArrayParam;
        this.menuItemArray = menuArrayParam;

    }


    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row, null, true);

        TextView nameField = rowView.findViewById(R.id.txt_name);
        TextView descField = rowView.findViewById(R.id.txt_desc);
        // no image... yet..
        // below sets the values of the objects to values from the arrays
        nameField.setText(menuItemArray[position]);
        descField.setText(menuDescArray[position]);

        return rowView;
    }
}
