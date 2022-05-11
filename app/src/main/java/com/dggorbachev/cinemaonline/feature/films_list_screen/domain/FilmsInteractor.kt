package com.dggorbachev.cinemaonline.feature.films_list_screen.domain

import com.dggorbachev.cinemaonline.base.attempt
import com.dggorbachev.cinemaonline.feature.films_list_screen.data.api.FilmsRepo

class FilmsInteractor(val repo: FilmsRepo) {
    suspend fun getFilmsList() = attempt {
        repo.getFilmsList()
    }
}