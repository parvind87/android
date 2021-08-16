package com.iforbihar.recyclerviewex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.myrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        int[] imageIds=new int[]{
                R.drawable.icon,
                R.drawable.linkedin,
                R.drawable.twiter,
                R.drawable.whatsapp,
                R.drawable.youtube
        };
        String[] names=new String[]{
                "Dummy Image",
                "LinkedIn",
                "twitter",
                "whatsapp",
                "youtube"
        };
        MyRecyclerAdapter adapter=new MyRecyclerAdapter(imageIds,names);
        recyclerView.setAdapter(adapter);
    }
}