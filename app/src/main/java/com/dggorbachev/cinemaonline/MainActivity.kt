package com.dggorbachev.cinemaonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dggorbachev.cinemaonline.base.navigation.BackButtonListener
import com.dggorbachev.cinemaonline.base.navigation.Screens
import com.dggorbachev.cinemaonline.databinding.ActivityMainBinding
import com.dggorbachev.cinemaonline.feature.films_list_screen.ui.FilmsListFragment
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val router: Router by inject()
    private val navigatorHolder: NavigatorHolder by inject()
    private val navigator = object : AppNavigator(this, R.id.flMain) {
        override fun applyCommands(commands: Array<out Command>) {
            super.applyCommands(commands)
            supportFragmentManager.executePendingTransactions()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigatorHolder.setNavigator(navigator)
//        router.newRootScreen(Screens.FilmsListScreen())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.mainTab -> {
                    val screen = Screens.FilmsListScreen()
                    router.newRootScreen(screen)
                }
                R.id.bookmarksTab -> {
                    val screen = Screens.BookmarksScreen()
                    router.newRootScreen(screen)
                }
            }
            true
        }
        binding.bottomNavigationView.selectedItemId = R.id.mainTab
    }


    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.flMain)
        if (fragment != null && fragment is BackButtonListener
            && (fragment as BackButtonListener).onBackPressed()
        ) {
            return
        } else {
            super.onBackPressed()
        }
    }

    fun controlBar(visibility: Int) {
        binding.bottomNavigationView.visibility = visibility
    }
}