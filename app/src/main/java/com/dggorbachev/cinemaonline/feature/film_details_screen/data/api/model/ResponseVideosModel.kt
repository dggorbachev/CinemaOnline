package com.dggorbachev.cinemaonline.feature.film_details_screen.data.api.model

import com.dggorbachev.cinemaonline.feature.film_details_screen.data.api.model.VideoModel
import com.google.gson.annotations.SerializedName

data class ResponseVideosModel(
    @SerializedName("results")
    val results: List<VideoModel>
)