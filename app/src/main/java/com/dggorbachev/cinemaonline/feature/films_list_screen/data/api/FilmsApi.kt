package com.dggorbachev.cinemaonline.feature.films_list_screen.data.api

import com.dggorbachev.cinemaonline.base.common.Constants.API_KEY
import com.dggorbachev.cinemaonline.feature.films_list_screen.data.api.model.ResponseFilmsModel
import retrofit2.http.GET

// https://api.themoviedb.org/3/movie/popular?api_key=<<api_key>>&language=en-US&page=1

interface FilmsApi {
    @GET("/3/movie/now_playing?api_key=$API_KEY&language=en-US&page=1")
    suspend fun getFilmsList(): ResponseFilmsModel
}