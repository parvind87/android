package com.example.retrofitapp2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("v3/6360ab61-dfcf-4af1-b7b2-ee52d9081d7a")
    Call<JSONResponse> getMovies();
}
