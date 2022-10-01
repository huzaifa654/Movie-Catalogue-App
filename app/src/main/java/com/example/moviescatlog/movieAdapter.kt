package com.example.moviescatlog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviescatlog.model.movie
import kotlinx.android.synthetic.main.movie_item.view.*

class movieAdapter (
    private  val movies : List<movie>

): RecyclerView.Adapter<movieAdapter.movieViewHolder>(){
    class movieViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private  val Movie_Base="https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie: movie){

            itemView.movieTitle.text=movie.title
            itemView.releaseDate.text=movie.release
            Glide.with(itemView).load(Movie_Base + movie.poster).into(itemView.moviePoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movieViewHolder {
        return movieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false))
    }

    override fun onBindViewHolder(holder: movieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }

    override fun getItemCount(): Int= movies.size
}