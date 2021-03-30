package com.syahrizal.submission3daftarfilm.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.syahrizal.submission3daftarfilm.data.source.local.entity.MovieEntity
import com.syahrizal.submission3daftarfilm.data.source.local.entity.TVShowEntity

@Database(entities = [MovieEntity::class, TVShowEntity::class],
    version = 1,
    exportSchema = false)
abstract class FilmDatabase : RoomDatabase() {

    abstract fun FilmDao(): FilmDao
    companion object {
        @Volatile
        private var INSTANCE: FilmDatabase? = null

        fun getInstance(context: Context): FilmDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                    FilmDatabase::class.java, "movie_catalogue.db").build()
            }
    }
}