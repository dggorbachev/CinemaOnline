package com.dggorbachev.cinemaonline.feature.films_list_screen.data.api

import com.dggorbachev.cinemaonline.feature.films_list_screen.data.api.model.ResponseVideosModel

class VideosRemoteSource(private val videosApi: VideosApi) {
    suspend fun getFilmsList(movieId: Int): ResponseVideosModel {
        return videosApi.getVideosList(movieId = movieId)
    }
}