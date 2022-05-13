package com.dggorbachev.cinemaonline.feature.film_details_screen.ui

import com.dggorbachev.cinemaonline.base.Event
import com.dggorbachev.cinemaonline.feature.film_details_screen.domain.model.VideoDomainModel
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel


data class ViewState(
    val videoKey: String,
    val filmDomainModel: FilmDomainModel
)

sealed class DataEvent : Event {
    data class OnLoadData(val movieId: Int) : DataEvent()
    data class SuccessVideosRequest(val videosList: List<VideoDomainModel>) : DataEvent()
    object ErrorVideosRequest : DataEvent()
}

sealed class UiEvent : Event {
    data class OnWatchClick(val videoKey: String) : UiEvent()
}