package com.dggorbachev.cinemaonline.feature.films_list_screen.domain

import com.dggorbachev.cinemaonline.base.attempt
import com.dggorbachev.cinemaonline.base.mapToList
import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.data.BookmarksRepo
import com.dggorbachev.cinemaonline.feature.films_list_screen.data.api.FilmsRepo

class FilmsInteractor(val filmsRepo: FilmsRepo, val bookmarksRepo: BookmarksRepo) {
    suspend fun getFilmsList() = attempt {
        mapToList(filmsRepo.getFilmsList(), bookmarksRepo.read())
    }
}