package com.myapplicationdev.android.tw_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class YearAdapter extends ArrayAdapter {

    private ArrayList<Year> yy;
    private Context context;
    private TextView tvYear;

    public YearAdapter(Context context, int resource, ArrayList<Year> objects){
        super(context, resource,objects);
        // Store the food that is passed to this adapter
        yy = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
// "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);
        Year currentYear = yy.get(position);
        tvYear = (TextView) rowView.findViewById(R.id.tvRow);
        tvYear.setText(currentYear.getName());
        return rowView;
    }
}

