package com.dggorbachev.cinemaonline.feature.film_details_screen.data

import com.dggorbachev.cinemaonline.feature.film_details_screen.data.api.model.VideoModel
import com.dggorbachev.cinemaonline.feature.film_details_screen.domain.model.VideoDomainModel
import com.dggorbachev.cinemaonline.feature.films_list_screen.data.api.model.FilmModel
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel

fun VideoModel.toDomain() = VideoDomainModel(
    key = key,
    type = type
)