package com.dggorbachev.cinemaonline.di

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.themoviedb.org/3/movie/"

// https://api.themoviedb.org/3/movie/popular?api_key=b32e778f5c0af4267214d2b112e35096&language=en-US&page=1
val appModule = module {

    single {
        OkHttpClient.Builder()
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }
}