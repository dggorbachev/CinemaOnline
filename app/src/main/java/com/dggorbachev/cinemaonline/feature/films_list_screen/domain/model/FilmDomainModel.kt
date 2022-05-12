package com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilmDomainModel(
    val id: Int,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val genreIds: List<Int>,
    val backdropPath: String? = "",
    val posterPath: String? = "",
    val voteAverage: Float
) : Parcelable