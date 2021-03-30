package com.syahrizal.submission3daftarfilm.di

import android.content.Context
import com.syahrizal.submission3daftarfilm.data.MovieCatalogueRepository
import com.syahrizal.submission3daftarfilm.data.source.local.LocalDataSource
import com.syahrizal.submission3daftarfilm.data.source.local.room.FilmDatabase
import com.syahrizal.submission3daftarfilm.data.source.remote.RemoteDataSource
import com.syahrizal.submission3daftarfilm.utils.AppExecutors

object Injection {

    fun provideRepository(context: Context): MovieCatalogueRepository {
        val database = FilmDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.FilmDao())
        val appExecutors = AppExecutors()
        return MovieCatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}