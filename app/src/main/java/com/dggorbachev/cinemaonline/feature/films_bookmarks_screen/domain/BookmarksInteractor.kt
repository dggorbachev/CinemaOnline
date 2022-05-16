package com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.domain

import androidx.lifecycle.LiveData
import com.dggorbachev.cinemaonline.base.attempt
import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.data.BookmarksRepo
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel

class BookmarksInteractor(private val repo: BookmarksRepo) {
    suspend fun create(filmDomainModel: FilmDomainModel) =
        repo.create(filmDomainModel = filmDomainModel)

    suspend fun read(): List<FilmDomainModel> = repo.read()
    suspend fun update(filmDomainModel: FilmDomainModel) =
        repo.update(filmDomainModel = filmDomainModel)

    suspend fun delete(filmDomainModel: FilmDomainModel) =
        attempt { repo.delete(filmDomainModel = filmDomainModel) }
}