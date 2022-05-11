package com.dggorbachev.cinemaonline.base

import com.dggorbachev.cinemaonline.base.functional.Either

inline fun <reified T> attempt(func: () -> T): Either<Throwable, T> = try {
    Either.Right(func.invoke())
} catch (e: Throwable) {
    Either.Left(e)
}