package com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dggorbachev.cinemaonline.feature.films_bookmarks_screen.data.local.BookmarkEntity

@Dao
interface BookmarksDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(bookmarkEntity: BookmarkEntity)

    @Query("SELECT * FROM ${BookmarkEntity.TABLE_NAME}")
    suspend fun read(): List<BookmarkEntity>

    @Update
    suspend fun update(bookmarkEntity: BookmarkEntity)

    @Delete
    suspend fun delete(bookmarkEntity: BookmarkEntity)

    @Query("SELECT * FROM ${BookmarkEntity.TABLE_NAME} ORDER BY id DESC")
    fun subscribe(): LiveData<List<BookmarkEntity>>
}