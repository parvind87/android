package com.iforbihar.recyclerviewex;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
    private int[]  imageList;
    private String[]  nameList;

    public MyRecyclerAdapter(int[] imageList,String[]  nameList){
        this.imageList=imageList;
        this.nameList=nameList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_custom_recycler_view_item,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.img.setImageResource(imageList[position]);
        holder.txt.setText(nameList[position]);
    }

    @Override
    public int getItemCount() {
        return imageList.length;
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_icon);
            txt=itemView.findViewById(R.id.txt_name);
        }
    }
}
