package com.dggorbachev.cinemaonline.feature.films_list_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class ResponseFilmsModel(
    @SerializedName("results")
    val results: List<FilmModel>
)