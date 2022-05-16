package com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.data

import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.data.local.BookmarkEntity
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel


fun FilmDomainModel.toEntityModel() =
    BookmarkEntity(
        id = id,
        title = title,
        overview = overview,
        releaseDate = releaseDate,
        genreIds = genreIds,
        backdropPath = backdropPath,
        posterPath = posterPath,
        voteAverage = voteAverage,
        isFavorite = isFavorite
    )

fun BookmarkEntity.toDomainModel() =
    FilmDomainModel(
        id = id,
        title = title,
        overview = overview,
        releaseDate = releaseDate,
        genreIds = genreIds,
        backdropPath = backdropPath,
        posterPath = posterPath,
        voteAverage = voteAverage,
        isFavorite = isFavorite
    )