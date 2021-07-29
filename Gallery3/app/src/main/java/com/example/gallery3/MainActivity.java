package com.example.gallery3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img,img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img1);
        img1 = findViewById(R.id.img2);
        img.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        img1.setImageResource(R.drawable.krishna1);
    }
}