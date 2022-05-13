package com.dggorbachev.cinemaonline.feature.film_details_screen.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.dggorbachev.cinemaonline.R
import com.dggorbachev.cinemaonline.feature.film_details_screen.domain.VideosInteractor
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class FilmDetailsFragment : Fragment(R.layout.fragment_film_details) {

    companion object {
        private const val EXTRA_MOVIE = "extra_movie"
        fun newInstance(movieModel: FilmDomainModel): FilmDetailsFragment {
            return FilmDetailsFragment().apply {
                arguments = bundleOf(EXTRA_MOVIE to movieModel)
            }
        }
    }

    private val movieModel: FilmDomainModel
        get() = requireArguments().getParcelable(EXTRA_MOVIE)!!

    private val viewModel by viewModel<FilmDetailsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner, Observer(::render))
    }

    private fun render(state: ViewState) {

    }
}