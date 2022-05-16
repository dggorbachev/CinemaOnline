package com.dggorbachev.cinemaonline.feature.films_list_screen.ui

import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.dggorbachev.cinemaonline.base.BaseViewModel
import com.dggorbachev.cinemaonline.base.Event
import com.dggorbachev.cinemaonline.base.common.Screen
import com.dggorbachev.cinemaonline.base.mapToList
import com.dggorbachev.cinemaonline.base.navigation.Screens
import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.domain.BookmarksInteractor
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.FilmsInteractor
import com.github.terrakok.cicerone.Router
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch

class FilmsListViewModel(
    private val filmsInteractor: FilmsInteractor,
    private val router: Router
) : BaseViewModel<ViewState>() {
    init {
        processDataEvent(DataEvent.OnLoadData)
    }

    override fun initialViewState(): ViewState {
        return ViewState(
            filmsList = listOf(),
            isLoading = false
        )
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.OnLoadData -> {
                processDataEvent(DataEvent.StartLoadData)
                filmsInteractor.getFilmsList().fold(
                    onSuccess = {
                        processDataEvent(DataEvent.SuccessFilmsRequest(it))
                    },
                    onError = {
                        processDataEvent(
                            DataEvent.ErrorFilmsRequest(
                                errorMessage = it.localizedMessage ?: ""
                            )
                        )
                    }
                )
            }
            is DataEvent.StartLoadData -> {
                return previousState.copy(isLoading = true)
            }
            is DataEvent.SuccessFilmsRequest -> {
                return previousState.copy(
                    filmsList = event.filmsList,
                    isLoading = false
                )
            }
            is DataEvent.ErrorFilmsRequest -> {
                return previousState.copy(
                    filmsList = listOf()
                )
            }
            is UiEvent.OnFilmClick -> {
                val screen =
                    Screens.FilmDetailsScreen(filmDomainModel = event.film, Screen.FILMSLIST)
                router.navigateTo(screen)
            }
        }
        return null
    }

}