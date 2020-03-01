package com.example.accompany;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ConcessionAdapterB extends BaseAdapter
{
    private String[] concessionList;
    private Context context;

    public ConcessionAdapterB(Context context, String[] concessions){
        this.concessionList = concessions;
        this.context = context;
    }

    @Override
    public int getCount(){
        return concessionList.length;
    }

    @Override
    public Object getItem(int pos){
        return concessionList[pos];
    }

    @Override
    public long getItemId(int pos){
        return 0;
    }

    public void update(String[] list){

        this.concessionList = list;
        this.notifyDataSetChanged();
    }

    @Override public View getView(int position, View convertView, ViewGroup parent){
        View rowView = View.inflate(context, R.layout.concession_list_row, null);
        TextView concessionName = rowView.findViewById(R.id.concession_name);
        concessionName.setText(concessionList[position]);
        return rowView;
    }
}
