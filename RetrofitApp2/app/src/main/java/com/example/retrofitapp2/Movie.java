package com.example.retrofitapp2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {
    // Model Class
    private int id;
    private String title;
    private float rating;
    private String poster;

    // we need to make object of class details
    // Different name from json, so we need to serialize it
    @SerializedName("Details")
    private MoreDetails moreDetails;

    // Constructor
    public Movie(int id, String title, float rating, String poster, MoreDetails moreDetails) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.poster = poster;
        this.moreDetails = moreDetails;
    }

    // Getters

    public String getTitle() {
        return title;
    }



    public float getRating() {
        return rating;
    }



    public String getPoster() {
        return poster;
    }



    public MoreDetails getMoreDetails() {
        return moreDetails;
    }


}
