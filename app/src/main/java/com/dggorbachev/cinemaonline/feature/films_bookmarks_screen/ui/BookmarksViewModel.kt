package com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.ui

import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.dggorbachev.cinemaonline.base.BaseViewModel
import com.dggorbachev.cinemaonline.base.Event
import com.dggorbachev.cinemaonline.base.common.Screen
import com.dggorbachev.cinemaonline.base.navigation.Screens
import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.domain.BookmarksInteractor
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.launch

class BookmarksViewModel(
    private val router: Router,
    private val bookmarksInteractor: BookmarksInteractor
) :
    BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.RefreshDataBase)
    }

    override fun initialViewState(): ViewState {
        return ViewState(filmsList = emptyList())
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.RefreshDataBase -> {
                val newFilmsList = bookmarksInteractor.read()
                return previousState.copy(filmsList = newFilmsList)
            }
            is UiEvent.OnBookmarkClick -> {
                bookmarksInteractor.delete(event.filmDomainModel)
            }
            is UiEvent.OnFilmClick -> {
                val screen = Screens.FilmDetailsScreen(
                    filmDomainModel = event.filmDomainModel,
                    Screen.BOOKMARKS
                )
                router.navigateTo(screen)
            }
            is UiEvent.RefreshScreen -> {
                processDataEvent(DataEvent.RefreshDataBase)
            }

            //else -> return null
        }
        return null
    }
}