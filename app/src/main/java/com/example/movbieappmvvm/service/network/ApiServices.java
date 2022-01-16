package com.example.movbieappmvvm.service.network;

import com.example.movbieappmvvm.service.model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices
{
    @GET("3/movie/top_rated?api_key=3748aee548e5985a6e01e22331e43eb8")
    Call<MovieModel>getTopRatedMovieList();

}
