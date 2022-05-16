package com.dggorbachev.cinemaonline.base

import com.dggorbachev.cinemaonline.base.functional.Either
import com.dggorbachev.cinemaonline.feature.films_list_screen.domain.model.FilmDomainModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> attempt(func: () -> T): Either<Throwable, T> = try {
    Either.Right(func.invoke())
} catch (e: Throwable) {
    Either.Left(e)
}

inline fun <reified T> genericType() = object : TypeToken<T>() {}.type

fun mapToList(
    oldList: List<FilmDomainModel>,
    newList: List<FilmDomainModel>
): List<FilmDomainModel> {
    return oldList.map { film ->
        film.copy(isFavorite = newList.map { it.id }.contains(film.id))
    }
}