package com.example.gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
GridView gridView;
ImageView img;

ArrayList studentsList;
ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.grid_view);
        ArrayList<Integer> myImageList = new ArrayList<>();
        myImageList.add(R.drawable.sachin);
        myImageList.add(R.drawable.krishna1);
        myImageList.add(R.drawable.krishna1);
        myImageList.add(R.drawable.krishna1);
        myImageList.add(R.drawable.krishna1);
        myImageList.add(R.drawable.krishna1);
        myImageList.add(R.drawable.krishna1);
        myImageList.add(R.drawable.krishna1);

        studentsList=new ArrayList();
        studentsList.add("Sachin");
        studentsList.add("Krishna");
        studentsList.add("Rahul");
        studentsList.add("Rishabh");
        studentsList.add("Virat");
        studentsList.add("Dhoni");
        studentsList.add("Gilchrist");
        studentsList.add("Next");

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,studentsList);
        gridView.setAdapter(adapter);
     //   img =findViewById(R.id.img);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

           //      Toast.makeText(MainActivity.this, (Integer) studentsList.get(position), Toast.LENGTH_SHORT).show();
           //  img.setImageResource(myImageList.get(position));
              //  ImageView imageView = (ImageView) findViewById(R.id.my_image_view);
                img =findViewById(R.id.img);

              //  Glide.with(v).load("http://goo.gl/gEgYUd").into(img);


            }
        });


    }

//    @Override
//    public void onClick(View v) {
//        img.setImageResource(R.drawable.krishna1);
//    }
}