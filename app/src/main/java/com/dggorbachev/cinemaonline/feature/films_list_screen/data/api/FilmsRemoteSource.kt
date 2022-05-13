package com.dggorbachev.cinemaonline.feature.films_list_screen.data.api

import com.dggorbachev.cinemaonline.feature.films_list_screen.data.api.model.ResponseFilmsModel

class FilmsRemoteSource(private val filmsApi: FilmsApi) {
    suspend fun getFilmsList(): ResponseFilmsModel {
        return filmsApi.getFilmsList()
    }

//    suspend fun getVideosList(): ResponseVideosModel {
//        val movieId=this.filmsApi.getFilmsList().results.
//        return videosApi.getVideosList(@Path("movie_id") movieId: )
//    }
}