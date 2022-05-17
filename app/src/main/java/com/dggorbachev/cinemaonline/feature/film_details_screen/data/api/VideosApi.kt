package com.dggorbachev.cinemaonline.feature.film_details_screen.data.api

import androidx.annotation.IntRange
import com.dggorbachev.cinemaonline.base.common.Constants
import com.dggorbachev.cinemaonline.feature.film_details_screen.data.api.model.ResponseVideosModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// https://api.themoviedb.org/3/movie/{movie_id}/videos?api_key=<<api_key>>&language=en-US

interface VideosApi {
    @GET("/3/movie/{movie_id}/videos")
    suspend fun getVideosList(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = Constants.TMDB_API_KEY,
        @Query("language") language: String = "en-US"
    ): ResponseVideosModel
}