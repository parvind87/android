package com.example.iforbihar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class myAdapter extends RecyclerView.Adapter<myAdapter.holder> {
    Datum []data;
    Context context;
  //  String data[];

    public myAdapter(Datum[] data,Context context) {

        this.data = data;
        this.context = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public holder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.singlerow,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull myAdapter.holder holder, int position) {
        Datum datum=data[position];
        holder.tv.setText(datum.getName());
        //holder.tv.setText("Parvind");
        //holder.tv.setText("");
      //  Glide.with(holder.img.getContext()).load("https://via.placeholder.com/350x150").into(holder.img);
        //Glide.with(holder.img.getContext()).load("http://10.0.2.2/android_db_pool/images/"+datum.getImage()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    class holder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv;


        public holder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.imageholder);
            tv = (TextView)itemView.findViewById(R.id.theader);


        }
    }

}
