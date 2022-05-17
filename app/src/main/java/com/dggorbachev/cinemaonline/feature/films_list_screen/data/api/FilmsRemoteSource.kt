package com.dggorbachev.cinemaonline.feature.films_list_screen.data.api

import com.dggorbachev.cinemaonline.feature.films_list_screen.data.api.model.ResponseFilmsModel

class FilmsRemoteSource(private val filmsApi: FilmsApi) {
    suspend fun getFilmsList(): ResponseFilmsModel {
        return filmsApi.getFilmsList()
    }
}