package com.dggorbachev.cinemaonline.feature.films_list_screen.di

import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.data.BookmarksRepo
import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.domain.BookmarksInteractor
import com.dggorbachev.cinemaonline.feature.films_list_screen.data.api.FilmsApi
import com.dggorbachev.cinemaonline.feature.films_list_screen.data.api.FilmsRemoteSource
import com.dggorbachev.cinemaonline.feature.films_list_screen.data.api.FilmsRepo
import com.dggorbachev.cinemaonline.feature.films_list_screen.data.api.FilmsRepoImpl
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.FilmsInteractor
import com.dggorbachev.cinemaonline.feature.films_list_screen.ui.FilmsListViewModel
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val filmListScreenModule = module {
    single<FilmsApi> {
        get<Retrofit>().create(FilmsApi::class.java)
    }

    single<FilmsRemoteSource> {
        FilmsRemoteSource(get<FilmsApi>())
    }

    single<FilmsRepo> {
        FilmsRepoImpl(get<FilmsRemoteSource>())
    }

    single<FilmsInteractor> {
        FilmsInteractor(get<FilmsRepo>(), get<BookmarksRepo>())
    }

    viewModel<FilmsListViewModel> {
        FilmsListViewModel(
            get<FilmsInteractor>(),
            get<Cicerone<Router>>().router
        )
    }
}