package com.example.retrofitapp2;

public class MoreDetails {
    // Model class for details data
    private String release;
    private String category;
    private String duration;

    // Getters
    public String getRelease() {
        return release;
    }

    public String getCategory() {
        return category;
    }

    public String getDuration() {
        return duration;
    }


    // COnstructor
    public MoreDetails(String release, String category, String duration) {
        this.release = release;
        this.category = category;
        this.duration = duration;
    }
}
