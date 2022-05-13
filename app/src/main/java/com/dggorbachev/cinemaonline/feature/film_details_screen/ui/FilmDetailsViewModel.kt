package com.dggorbachev.cinemaonline.feature.film_details_screen.ui

import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.dggorbachev.cinemaonline.base.BaseViewModel
import com.dggorbachev.cinemaonline.base.Event
import com.dggorbachev.cinemaonline.base.navigation.Screens
import com.dggorbachev.cinemaonline.base.utils.SingleLiveEvent
import com.dggorbachev.cinemaonline.feature.film_details_screen.domain.VideosInteractor
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel
import com.dggorbachev.cinemaonline.feature.player_screen.ui.PlayerActivity
import com.github.terrakok.cicerone.Router

class FilmDetailsViewModel(
    private val videosInteractor: VideosInteractor,
    private val router: Router,
    private val film: FilmDomainModel
) : BaseViewModel<ViewState>() {

    val openFilm = SingleLiveEvent<UiEvent.OnWatchClick>()

    init {
        processDataEvent(DataEvent.OnLoadData(film.id))
    }

    override fun initialViewState(): ViewState {
        return ViewState(
            videoKey = "",
            filmDomainModel = film
        )
    }


    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.OnLoadData -> {
                videosInteractor.getVideosList(event.movieId).fold(
                    onSuccess = {
                        if (it.isEmpty())
                            processDataEvent(DataEvent.ErrorVideosRequest)
                        else
                            processDataEvent(DataEvent.SuccessVideosRequest(it))
                    },
                    onError = {
                        processDataEvent(
                            DataEvent.ErrorVideosRequest
                        )
                    }
                )
            }
            is DataEvent.SuccessVideosRequest -> {
                return previousState.copy(
                    videoKey = event.videosList[0].key
                )
            }
            is DataEvent.ErrorVideosRequest -> {
                return previousState.copy(
                    videoKey = "dQw4w9WgXcQ"
                )
            }
            is UiEvent.OnWatchClick -> {
                openFilm.value = event
            }
        }
        return null
    }

}