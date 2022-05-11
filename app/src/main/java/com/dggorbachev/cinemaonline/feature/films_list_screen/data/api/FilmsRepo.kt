package com.dggorbachev.cinemaonline.feature.films_list_screen.data.api

import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel

interface FilmsRepo {
    suspend fun getFilmsList(): List<FilmDomainModel>
}