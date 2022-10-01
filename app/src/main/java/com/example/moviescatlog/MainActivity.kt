package com.example.moviescatlog

import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.LinearLayout
import com.example.moviescatlog.databinding.ActivityMainBinding
import com.example.moviescatlog.model.MovieResponse
import com.example.moviescatlog.services.MovieApiSerivice
import com.example.moviescatlog.model.movie
import com.example.moviescatlog.services.moviesApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import  androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.*





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.movies_list)
        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
        getMovieData { movie: List<movie> ->
            rv.adapter = movieAdapter(movie)


        }

    }

    private fun getMovieData(callback: (List<movie>) -> Unit) {
        val apiService = MovieApiSerivice.getInstance().create(moviesApiInterface::class.java)
        apiService.getMoviesList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }


        })

    }
}
