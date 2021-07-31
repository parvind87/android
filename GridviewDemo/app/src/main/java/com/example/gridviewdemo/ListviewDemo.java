package com.example.gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class ListviewDemo extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    ListView listView;
    Button btn,btn1;
    EditText fname;
    //private String states;
    String[] states = {"Bihar","Delhi", "UP","Haryana","Maharastra"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_demo);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(this);
        listView=findViewById(R.id.listview);
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                states);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn1:
                fname = findViewById(R.id.fname);
                String f_name = fname.getText().toString();
                Intent intent1 = new Intent(this, Customlistview.class);
                intent1.putExtra("fname",f_name);
                intent1.putExtra("lname","Kumar");
                startActivity(intent1);
                break;
        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "I live at "+ states[position], Toast.LENGTH_SHORT).show();
    }
}