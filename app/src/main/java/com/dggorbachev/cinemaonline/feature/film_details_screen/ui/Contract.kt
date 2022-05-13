package com.dggorbachev.cinemaonline.feature.film_details_screen.ui

import com.dggorbachev.cinemaonline.base.Event
import com.dggorbachev.cinemaonline.feature.film_details_screen.domain.model.VideoDomainModel
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel


data class ViewState(
    val videosList: List<VideoDomainModel>,
    val filmDomainModel: FilmDomainModel
)

sealed class DataEvent : Event {
    data class OnLoadData(val movie_id: Int) : DataEvent()
    data class SuccessVideosRequest(val videosList: List<VideoDomainModel>) : DataEvent()
    data class ErrorVideosRequest(val errorMessage: String) : DataEvent()
}