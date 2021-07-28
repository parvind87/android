package com.example.iforbihar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String url="https://jsonplaceholder.typicode.com/users?_limit=5";
    RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv=(RecyclerView)findViewById(R.id.rclview);
        rcv.setLayoutManager(new LinearLayoutManager(this));
       // String arr[]={"C","C++","Java","C","C++","Java","C","C++","Java","C","C++","Java","C","C++","Java"};
       // rcv.setAdapter(new myAdapter(arr));
        StringRequest request=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                GsonBuilder gsonBuilder=new GsonBuilder();
                Gson gson=gsonBuilder.create();
                Datum []data=gson.fromJson(response,Datum[].class);
                rcv.setAdapter(new myAdapter(data,getApplicationContext()));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(request);

    }
}