package com.dggorbachev.cinemaonline.feature.films_list_screen.ui

import com.dggorbachev.cinemaonline.base.Event
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel

data class ViewState(
    val filmsList: List<FilmDomainModel>,
    val isLoading: Boolean
)

sealed class UiEvent : Event {
    data class OnFilmClick(val film: FilmDomainModel) : UiEvent()
}

sealed class DataEvent : Event {
    object StartLoadData : DataEvent()
    object OnLoadData : DataEvent()
    data class SuccessFilmsRequest(val filmsList: List<FilmDomainModel>) : DataEvent()
    data class ErrorFilmsRequest(val errorMessage: String) : DataEvent()
}