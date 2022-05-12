package com.dggorbachev.cinemaonline.feature.film_details_screen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dggorbachev.cinemaonline.R
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class FilmDetailsFragment : Fragment(R.layout.fragment_film_details) {

    companion object {
        private const val EXTRA_MOVIE = "extra_movie"
        fun newInstance(movieModel: FilmDomainModel): FilmDetailsFragment {
            return FilmDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(EXTRA_MOVIE, movieModel)
                }
            }
        }
    }
}