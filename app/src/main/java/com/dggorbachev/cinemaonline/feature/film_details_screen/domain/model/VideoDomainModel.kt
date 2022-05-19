package com.dggorbachev.cinemaonline.feature.film_details_screen.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoDomainModel(
    val key: String,
    val type: String
) : Parcelable