package com.example.myapplication.activities;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.QuickContactBadge;

import com.example.myapplication.R;

public class EventHandlingActivity extends AppCompatActivity {
private Button button;
private Button buttonClick;
MediaPlayer player;
    public void gotoCal(View v){
        Intent intent = new Intent(this, CalActivity.class);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_handling_ui);
        button=(Button) findViewById(R.id.button);
        buttonClick =(Button) findViewById(R.id.clickCount);
        button.setOnClickListener(new OnClickListener(){
        @Override
            public void onClick(View v){
            openActivity2();

        }
        });

        buttonClick.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v("btn","this is mesg 1");

            }
        });
//        calbutton=(Button) findViewById(R.id.btncal);
//        calbutton.setOnClickListener(new OnClickListener(){
//            @Override
//            public void onClick(View v){
//               // openActivity2();
//                Intent intent = new Intent(this, CalActivity.class);
//                startActivity(intent);
//
//            }
//        });
    }
   public void openActivity2(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    public void play(View v){
        if(player==null){
            player = MediaPlayer.create(this,R.raw.wind);
            player.start();
        }

    }

}