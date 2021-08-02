package com.iforbihar.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button start,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.btn_play);
        start.setOnClickListener(this);
        stop=findViewById(R.id.btn_stop);
        stop.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intentservice = new Intent(this,MyService.class);
        switch(v.getId()){
            case R.id.btn_play:
            {
                startService(intentservice);
            }
            break;
            case R.id.btn_stop:
            {
                stopService(intentservice);
            }
            break;
        }
    }
}