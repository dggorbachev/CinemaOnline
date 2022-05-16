package com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.ui

import com.dggorbachev.cinemaonline.base.Event
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel

data class ViewState(
    val filmsList: List<FilmDomainModel>
)

sealed class UiEvent : Event {
    data class OnFilmClick(val filmDomainModel: FilmDomainModel) : UiEvent()
    data class OnBookmarkClick(val filmDomainModel: FilmDomainModel) : UiEvent()
    object RefreshScreen : UiEvent()
}

sealed class DataEvent : Event {
    object RefreshDataBase : DataEvent()
}