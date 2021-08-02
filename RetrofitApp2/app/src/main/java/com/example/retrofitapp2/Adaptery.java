package com.example.retrofitapp2;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {

    private Context mContext;
    private List<Movie> moviesList;


    public Adaptery(Context mContext, List<Movie> moviesList) {
        this.mContext = mContext;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v ;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.movie_item, parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.title.setText(moviesList.get(position).getTitle());

        // The Trick: Getting data from the nested json object
        holder.duration.setText(moviesList.get(position).getMoreDetails().getDuration());
        holder.category.setText(moviesList.get(position).getMoreDetails().getCategory());
        holder.release.setText(moviesList.get(position).getMoreDetails().getRelease());


        // Adding Glide library to display the images
        Glide.with(mContext)
                .load(moviesList.get(position).getPoster())
                .into(holder.img);


        // Setting the rating bar value
        // Rating bar is 5 and ratings is over 10
        holder.ratingBar.setRating((Float.parseFloat(String.valueOf(moviesList.get(position).getRating())))/2);

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView duration;
        ImageView img;

        RatingBar ratingBar;
        TextView category;
        TextView release;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textView2);
            duration = itemView.findViewById(R.id.textView3);
            img = itemView.findViewById(R.id.imageView);
            ratingBar =  itemView.findViewById(R.id.ratingBar);
            category = itemView.findViewById(R.id.textView);
            release = itemView.findViewById(R.id.textView4);


        }
    }
}
