package com.dggorbachev.cinemaonline.feature.film_details_screen.domain

import com.dggorbachev.cinemaonline.base.attempt
import com.dggorbachev.cinemaonline.feature.film_details_screen.data.api.VideosRepo

class VideosInteractor(val repo: VideosRepo) {
    suspend fun getVideosList(movieId: Int) = attempt {
        repo.getVideosList(movieId).filter {
            it.type == "Trailer"
        }
    }
}