package com.dggorbachev.cinemaonline.di

import androidx.room.Room
import com.dggorbachev.cinemaonline.AppDataBase
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import okhttp3.OkHttpClient
import org.koin.dsl.module
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.themoviedb.org/"
const val DATA_BASE = "DATA_BASE"

// https://api.themoviedb.org/3/movie/popular?api_key=<<api_key>>&language=en-US&page=1
// https://api.themoviedb.org/3/movie/{movie_id}/videos?api_key=<<api_key>>&language=en-US
val appModule = module {

    single {
        OkHttpClient.Builder()
            .build()
    }

    // logging api data
    val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}

val navigationModule = module {
    single<Cicerone<Router>> {
        Cicerone.create(Router())
    }

    single<NavigatorHolder> {
        get<Cicerone<Router>>().getNavigatorHolder()
    }

    single<Router> {
        get<Cicerone<Router>>().router
    }
}

val dataBaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDataBase::class.java, DATA_BASE)
            .fallbackToDestructiveMigration()
            .build()
    }
    single {
        get<AppDataBase>().bookmarksDAO()
    }
}