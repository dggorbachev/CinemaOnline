package com.dggorbachev.cinemaonline.base.navigation

import com.dggorbachev.cinemaonline.feature.film_details_screen.ui.FilmDetailsFragment
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel
import com.dggorbachev.cinemaonline.feature.films_list_screen.ui.FilmsListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun FilmsListScreen() = FragmentScreen { FilmsListFragment.newInstance() }
    fun FilmDetailsScreen(filmDomainModel: FilmDomainModel) =
        FragmentScreen { FilmDetailsFragment.newInstance(filmDomainModel) }

//    fun PlayerScreen(movieUrl: String) = FragmentScreen { PlayerFragment.newInstance(movieUrl) }
// Factory
//    fun SomeScreen() = FragmentScreen { factory: FragmentFactory -> ... }
}