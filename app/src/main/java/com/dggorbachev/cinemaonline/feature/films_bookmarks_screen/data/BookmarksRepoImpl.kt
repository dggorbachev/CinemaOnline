package com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.data.BookmarksRepo
import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.data.local.BookmarksDAO
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel

class BookmarksRepoImpl(private val bookmarksDAO: BookmarksDAO) : BookmarksRepo {
    override suspend fun create(filmDomainModel: FilmDomainModel) {
        bookmarksDAO.create(filmDomainModel.toEntityModel())
    }

    override suspend fun read(): List<FilmDomainModel> {
        return bookmarksDAO.read().map { it.toDomainModel() }
    }

    override suspend fun update(filmDomainModel: FilmDomainModel) {
        bookmarksDAO.update(filmDomainModel.toEntityModel())
    }

    override suspend fun delete(filmDomainModel: FilmDomainModel) {
        bookmarksDAO.delete(filmDomainModel.toEntityModel())
    }

    override suspend fun subscribe(): LiveData<List<FilmDomainModel>> {
        return bookmarksDAO.subscribe().map { it -> it.map { it.toDomainModel() } }
    }
}