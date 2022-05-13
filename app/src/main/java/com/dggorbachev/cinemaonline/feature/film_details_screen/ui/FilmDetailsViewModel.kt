package com.dggorbachev.cinemaonline.feature.film_details_screen.ui

import com.dggorbachev.cinemaonline.base.BaseViewModel
import com.dggorbachev.cinemaonline.base.Event
import com.dggorbachev.cinemaonline.feature.film_details_screen.domain.VideosInteractor
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel
import com.github.terrakok.cicerone.Router

class FilmDetailsViewModel(
    private val videosInteractor: VideosInteractor,
    private val router: Router
) : BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState {
        return ViewState(
            videosList = listOf()
        )
    }


    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnWatchClick -> {

            }
        }
        return null
    }

}