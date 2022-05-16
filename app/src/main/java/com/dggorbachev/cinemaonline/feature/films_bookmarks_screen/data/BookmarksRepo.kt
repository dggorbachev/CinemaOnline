package com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.data

import androidx.lifecycle.LiveData
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel

interface BookmarksRepo {
    suspend fun create(filmDomainModel: FilmDomainModel)
    suspend fun read(): List<FilmDomainModel>
    suspend fun update(filmDomainModel: FilmDomainModel)
    suspend fun delete(filmDomainModel: FilmDomainModel)
    suspend fun subscribe(): LiveData<List<FilmDomainModel>>
}