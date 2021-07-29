package com.example.gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListviewDemo extends AppCompatActivity implements View.OnClickListener {
    ListView listView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] states = {"Bihar","Delhi", "UP","Haryana","Maharastra"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_demo);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);
        listView=findViewById(R.id.listview);
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                states);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}