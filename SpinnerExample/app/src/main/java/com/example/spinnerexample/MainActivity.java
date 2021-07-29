package com.example.spinnerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity    {
Spinner spinner;
GridView view;
ArrayList studentList;
ArrayAdapter adapter;
ArrayList allStates = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  spinner.setOnTouchListener(this);
        view = findViewById(R.id.mygrid);
        studentList = new ArrayList();

        spinner = (Spinner) findViewById(R.id.sp_state);
        allStates.add("Bihar");
        allStates.add("UP");
        allStates.add("Haryana");
        allStates.add("Delhi");
        allStates.add("Madhya Pradesh");
        allStates.add("Maharastra");
        allStates.add("Rajasthan");
       ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,allStates);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinner.setAdapter(adapter);
       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               String selectedState = parent.getItemAtPosition(position).toString();
               Toast.makeText(MainActivity.this, "selected State = "+selectedState+position, Toast.LENGTH_SHORT).show();
               spinner.setSelection(position);
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });


    }




}