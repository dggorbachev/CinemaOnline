package com.dggorbachev.cinemaonline

import android.app.Application
import com.dggorbachev.cinemaonline.di.appModule
import com.dggorbachev.cinemaonline.di.navigationModule
import com.dggorbachev.cinemaonline.feature.films_list_screen.di.filmListScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule, filmListScreenModule, navigationModule)
        }
    }
}