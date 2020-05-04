package com.myapplicationdev.android.tw_listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    ListView lv;
    TextView tv;
    ArrayAdapter aa;
    ArrayList<Year> year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)this.findViewById(R.id.lvItems);

        year = new ArrayList<Year>();
        year.add(new Year("Year 1"));
        year.add(new Year("Year 2"));
        year.add(new Year("Year 3"));


        aa = new YearAdapter(this, R.layout.row, year);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Year selectedYear = year.get(position);
                String[] info = {selectedYear.getName()};
                Intent i = new Intent(FirstActivity.this,SecondActivity.class);
                i.putExtra("info",info);
                startActivity(i);
            }
        });
    }
}
