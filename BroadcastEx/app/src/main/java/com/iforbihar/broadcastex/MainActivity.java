package com.iforbihar.broadcastex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
IntentFilter filter;
MyReceiver myReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //filter = new IntentFilter(Intent.ACTION_TIME_TICK);
        filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        myReceiver = new MyReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReceiver,filter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
        //unregisterReceiver(myReceiver,filter);
       // unregisterReceiver(myReceiver,filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReceiver);
    }
}