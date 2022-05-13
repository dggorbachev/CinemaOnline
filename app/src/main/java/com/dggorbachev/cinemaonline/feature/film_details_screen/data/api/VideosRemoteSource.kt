package com.dggorbachev.cinemaonline.feature.film_details_screen.data.api

import com.dggorbachev.cinemaonline.feature.film_details_screen.data.api.model.ResponseVideosModel

class VideosRemoteSource(private val videosApi: VideosApi) {
    suspend fun getVideosList(movieId: Int): ResponseVideosModel {
        return videosApi.getVideosList(movieId = movieId)
    }
}