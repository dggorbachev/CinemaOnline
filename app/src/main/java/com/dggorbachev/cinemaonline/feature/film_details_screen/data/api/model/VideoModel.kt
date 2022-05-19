package com.dggorbachev.cinemaonline.feature.film_details_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class VideoModel(
    @SerializedName("key")
    val key: String,
    @SerializedName("type")
    val type: String
)