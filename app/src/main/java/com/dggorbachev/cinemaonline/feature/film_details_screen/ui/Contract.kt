package com.dggorbachev.cinemaonline.feature.film_details_screen.ui

import com.dggorbachev.cinemaonline.base.Event
import com.dggorbachev.cinemaonline.feature.film_details_screen.domain.model.VideoDomainModel
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel


data class ViewState(
    val videosList: List<VideoDomainModel>
)

sealed class UiEvent : Event {
    data class OnWatchClick(val movie_id: Int) : UiEvent()
}