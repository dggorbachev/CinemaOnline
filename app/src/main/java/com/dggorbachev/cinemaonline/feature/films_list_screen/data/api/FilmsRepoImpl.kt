package com.dggorbachev.cinemaonline.feature.films_list_screen.data.api

import com.dggorbachev.cinemaonline.feature.films_list_screen.data.toDomain
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel

class FilmsRepoImpl(private val source: FilmsRemoteSource) : FilmsRepo {
    override suspend fun getFilmsList(): List<FilmDomainModel> {
        return source.getFilmsList().results.map {
            it.toDomain()
        }
    }
}