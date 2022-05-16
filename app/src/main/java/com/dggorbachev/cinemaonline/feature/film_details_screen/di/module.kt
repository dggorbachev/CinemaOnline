package com.dggorbachev.cinemaonline.feature.film_details_screen.di


import com.dggorbachev.cinemaonline.base.common.Screen
import com.dggorbachev.cinemaonline.feature.film_details_screen.data.api.VideosRemoteSource
import com.dggorbachev.cinemaonline.feature.film_details_screen.data.api.VideosApi
import com.dggorbachev.cinemaonline.feature.film_details_screen.data.api.VideosRepo
import com.dggorbachev.cinemaonline.feature.film_details_screen.data.api.VideosRepoImpl
import com.dggorbachev.cinemaonline.feature.film_details_screen.domain.VideosInteractor
import com.dggorbachev.cinemaonline.feature.film_details_screen.ui.FilmDetailsViewModel
import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.domain.BookmarksInteractor
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val videosListScreenModule = module {
    single<VideosApi> {
        get<Retrofit>().create(VideosApi::class.java)
    }

    single<VideosRemoteSource> {
        VideosRemoteSource(get<VideosApi>())
    }

    single<VideosRepo> {
        VideosRepoImpl(get<VideosRemoteSource>())
    }

    single<VideosInteractor> {
        VideosInteractor(get<VideosRepo>())
    }

    viewModel<FilmDetailsViewModel> { (filmModel: FilmDomainModel, previousScreen: Screen) ->
        FilmDetailsViewModel(
            get<VideosInteractor>(),
            get<Cicerone<Router>>().router,
            filmModel,
            get<BookmarksInteractor>()
        )
    }
}