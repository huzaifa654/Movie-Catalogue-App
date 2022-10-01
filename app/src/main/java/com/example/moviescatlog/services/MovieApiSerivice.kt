package com.example.moviescatlog.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApiSerivice {
    companion object{
        private const val Base_URL="https://api.themoviedb.org"
        private  var  retrofit : Retrofit? =null

        fun getInstance(): Retrofit{
            if (retrofit ==null){
                retrofit =Retrofit.Builder()
                    .baseUrl(Base_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}