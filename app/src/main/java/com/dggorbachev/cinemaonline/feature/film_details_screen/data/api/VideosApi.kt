package com.dggorbachev.cinemaonline.feature.film_details_screen.data.api

import com.dggorbachev.cinemaonline.base.common.Constants
import com.dggorbachev.cinemaonline.feature.film_details_screen.data.api.model.ResponseVideosModel
import retrofit2.http.GET
import retrofit2.http.Path

// https://api.themoviedb.org/3/movie/{movie_id}/videos?api_key=<<api_key>>&language=en-US

interface VideosApi {
    @GET("/3/movie/{movie_id}/videos?api_key=${Constants.TMDB_API_KEY}&language=en-US")
    suspend fun getVideosList(@Path("movie_id") movieId: Int): ResponseVideosModel
}