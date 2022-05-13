package com.dggorbachev.cinemaonline.feature.films_list_screen.ui

import com.dggorbachev.cinemaonline.base.BaseViewModel
import com.dggorbachev.cinemaonline.base.Event
import com.dggorbachev.cinemaonline.base.navigation.Screens
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.FilmsInteractor
import com.github.terrakok.cicerone.Router

class FilmsListViewModel(
    private val filmsInteractor: FilmsInteractor,
    private val router: Router
) : BaseViewModel<ViewState>() {
    init {
        processDataEvent(DataEvent.OnLoadData)
    }

    override fun initialViewState(): ViewState {
        return ViewState(
            filmsList = listOf()
        )
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.OnLoadData -> {
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
            is DataEvent.SuccessFilmsRequest -> {
                return previousState.copy(
                    filmsList = event.filmsList
                )
            }
            is DataEvent.ErrorFilmsRequest -> {
                return previousState.copy(
                    filmsList = listOf()
                )
            }
            is UiEvent.OnFilmClick -> {
                val screen = Screens.FilmDetailsScreen(filmDomainModel = event.film)
                router.navigateTo(screen)
            }
        }
        return null
    }

}