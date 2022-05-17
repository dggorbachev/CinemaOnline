package com.dggorbachev.cinemaonline.feature.films_list_screen.data.api

import androidx.annotation.IntRange
import com.dggorbachev.cinemaonline.base.common.Constants.TMDB_API_KEY
import com.dggorbachev.cinemaonline.feature.films_list_screen.data.api.model.ResponseFilmsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// https://api.themoviedb.org/3/movie/popular?api_key=<<api_key>>&language=en-US&page=1

interface FilmsApi {
    @GET("/3/movie/now_playing")
    suspend fun getFilmsList(
        @Query("api_key") apiKey: String = TMDB_API_KEY,
        @Query("page") @IntRange(from = 1) page: Int = 1,
        @Query("language") language: String = "en-US"
    ): ResponseFilmsModel
}