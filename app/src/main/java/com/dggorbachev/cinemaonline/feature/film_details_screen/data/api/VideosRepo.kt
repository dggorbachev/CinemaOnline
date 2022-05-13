package com.dggorbachev.cinemaonline.feature.film_details_screen.data.api

import com.dggorbachev.cinemaonline.feature.film_details_screen.domain.model.VideoDomainModel

interface VideosRepo {
    suspend fun getVideosList(movieId: Int): List<VideoDomainModel>
}