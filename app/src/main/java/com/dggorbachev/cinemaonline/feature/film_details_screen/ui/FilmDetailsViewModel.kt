package com.dggorbachev.cinemaonline.feature.film_details_screen.ui

import com.dggorbachev.cinemaonline.base.BaseViewModel
import com.dggorbachev.cinemaonline.base.Event
import com.dggorbachev.cinemaonline.feature.film_details_screen.domain.VideosInteractor
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel
import com.github.terrakok.cicerone.Router

class FilmDetailsViewModel(
    private val videosInteractor: VideosInteractor,
    private val router: Router,
    private val film: FilmDomainModel
) : BaseViewModel<ViewState>() {


    init {
        processDataEvent(DataEvent.OnLoadData(film.id))
    }

    override fun initialViewState(): ViewState {
        return ViewState(
            videosList = listOf(),
            filmDomainModel = film
        )
    }


    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.OnLoadData -> {
                videosInteractor.getVideosList(event.movie_id).fold(
                    onSuccess = {
                        processDataEvent(DataEvent.SuccessVideosRequest(it))
                    },
                    onError = {
                        processDataEvent(
                            DataEvent.ErrorVideosRequest(
                                errorMessage = it.localizedMessage ?: ""
                            )
                        )
                    }
                )
            }
            is DataEvent.SuccessVideosRequest -> {
                return previousState.copy(
                    videosList = event.videosList
                )
            }
            is DataEvent.ErrorVideosRequest -> {
                return previousState.copy(
                    videosList = listOf()
                )
            }
        }
        return null
    }

}