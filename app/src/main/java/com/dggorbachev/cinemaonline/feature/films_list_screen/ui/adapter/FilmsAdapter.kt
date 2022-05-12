package com.dggorbachev.cinemaonline.feature.films_list_screen.ui.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dggorbachev.cinemaonline.R
import com.dggorbachev.cinemaonline.base.common.Constants.IMG_URL
import com.dggorbachev.cinemaonline.base.utils.setThrottledClickListener
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel

class FilmsAdapter(
    private var filmsList: List<FilmDomainModel>,
    private val onFilmClick: (film: FilmDomainModel) -> Unit
) : RecyclerView.Adapter<FilmsAdapter.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val backImage: ImageView
        val rating: TextView
        val releaseDate: TextView
        val rvGenres: RecyclerView

        init {
            this.title = view.findViewById<TextView>(R.id.tvTitle)
            this.backImage = view.findViewById<ImageView>(R.id.ivBackdrop)
            this.rating = view.findViewById<TextView>(R.id.tvRating)
            this.releaseDate = view.findViewById<TextView>(R.id.tvReleaseDate)
            this.rvGenres = view.findViewById(R.id.rvGenres)
        }
    }

    lateinit var view: View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = filmsList[position].title
        holder.rating.text = getRating(position)
        holder.releaseDate.text = filmsList[position].releaseDate

        Glide.with(view)
            .load(IMG_URL + filmsList[position].backdropPath)
            .centerCrop()
            .into(holder.backImage)

        val layoutManager =
            LinearLayoutManager(holder.rvGenres.context, LinearLayoutManager.HORIZONTAL, false)
        layoutManager.initialPrefetchItemCount = filmsList[position].genreIds.size

        val genresAdapter = GenresAdapter(film = filmsList[position])
        holder.rvGenres.layoutManager = layoutManager
        holder.rvGenres.adapter = genresAdapter
        holder.rvGenres.setRecycledViewPool(viewPool)


        holder.backImage.setThrottledClickListener {
            onFilmClick(filmsList[position])
        }
    }

    override fun getItemCount(): Int {
        return filmsList.size
    }

    fun updateFilms(newArticles: List<FilmDomainModel>) {
        filmsList = newArticles
        notifyDataSetChanged()
    }

    fun getRating(position: Int) =
        (((filmsList[position].voteAverage * 10).toInt()).toString() + "%")
}