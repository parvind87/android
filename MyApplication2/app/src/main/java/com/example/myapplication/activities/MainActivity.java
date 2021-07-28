package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    //Button button;


    public void countClick(View v){
        Log.v("button","Click Count Clicked");
    }
    public void gotoScreen1(View v){
        Intent intent = new Intent(this, EventHandlingActivity.class);
        startActivity(intent);

    }
    public void gotoScreen2(View v){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public static class ListActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list);
        }
    }
}