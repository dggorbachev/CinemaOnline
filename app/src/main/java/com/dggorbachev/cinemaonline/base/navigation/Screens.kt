package com.dggorbachev.cinemaonline.base.navigation

import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.dggorbachev.cinemaonline.base.common.Screen
import com.dggorbachev.cinemaonline.feature.film_details_screen.ui.FilmDetailsFragment
import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.ui.BookmarksFragment
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel
import com.dggorbachev.cinemaonline.feature.films_list_screen.ui.FilmsListFragment
import com.dggorbachev.cinemaonline.feature.player_screen.ui.PlayerActivity
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen


object Screens {
    fun FilmsListScreen() = FragmentScreen { FilmsListFragment.newInstance() }
    fun FilmDetailsScreen(filmDomainModel: FilmDomainModel, screen: Screen) =
        FragmentScreen { FilmDetailsFragment.newInstance(filmDomainModel, screen) }

    fun BookmarksScreen() =
        FragmentScreen { BookmarksFragment.newInstance() }
// Factory
//    fun SomeScreen() = FragmentScreen { factory: FragmentFactory -> ... }
}