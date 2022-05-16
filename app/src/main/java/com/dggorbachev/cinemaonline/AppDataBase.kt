package com.dggorbachev.cinemaonline

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dggorbachev.cinemaonline.base.utils.IntConverter
import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.data.local.BookmarkEntity
import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.data.local.BookmarksDAO

@Database(entities = [BookmarkEntity::class], version = 1)
@TypeConverters(IntConverter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun bookmarksDAO(): BookmarksDAO
}