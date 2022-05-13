package com.dggorbachev.cinemaonline.feature.film_details_screen.data.api

import com.dggorbachev.cinemaonline.feature.film_details_screen.data.toDomain
import com.dggorbachev.cinemaonline.feature.film_details_screen.domain.model.VideoDomainModel


class VideosRepoImpl(private val source: VideosRemoteSource) : VideosRepo {
    override suspend fun getVideosList(movieId: Int): List<VideoDomainModel> {
        return source.getVideosList(movieId).results.map {
            it.toDomain()
        }
    }
}