package com.dggorbachev.cinemaonline.feature.films_list_screen.data

import com.dggorbachev.cinemaonline.feature.films_list_screen.data.api.model.FilmModel
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel

fun FilmModel.toDomain() = FilmDomainModel(
    id = id,
    title = title,
    overview = overview,
    releaseDate = releaseDate,
    genreIds = genreIds,
    posterPath = posterPath,
    backdropPath = backdropPath,
    voteAverage = voteAverage
)