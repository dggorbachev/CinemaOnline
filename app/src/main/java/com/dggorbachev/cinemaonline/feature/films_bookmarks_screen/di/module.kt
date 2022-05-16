package com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.di

import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.data.BookmarksRepo
import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.data.BookmarksRepoImpl
import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.data.local.BookmarksDAO
import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.domain.BookmarksInteractor
import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.ui.BookmarksViewModel
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.android.compat.ViewModelCompat.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val bookmarksScreenModule = module {
    single<BookmarksRepo> {
        BookmarksRepoImpl(get<BookmarksDAO>())
    }

    single<BookmarksInteractor> {
        BookmarksInteractor(get<BookmarksRepo>())
    }

    viewModel<BookmarksViewModel> {
        BookmarksViewModel(get<Cicerone<Router>>().router, get<BookmarksInteractor>())
    }
}