package com.example.moviescatlog.services

import android.telecom.Call
import com.example.moviescatlog.model.MovieResponse
import retrofit2.http.GET

interface moviesApiInterface {
    @GET("/3/movie/popular?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    fun  getMoviesList(): retrofit2.Call<MovieResponse>;
}