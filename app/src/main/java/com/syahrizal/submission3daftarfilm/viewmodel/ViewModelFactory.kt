package com.syahrizal.submission3daftarfilm.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.syahrizal.submission3daftarfilm.data.MovieCatalogueRepository
import com.syahrizal.submission3daftarfilm.di.Injection.provideRepository

class ViewModelFactory private constructor(private val mMovieCatalogueRepository: MovieCatalogueRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) ->
                MoviesViewModel(mMovieCatalogueRepository) as T
            modelClass.isAssignableFrom(TVShowsViewModel::class.java) ->
                TVShowsViewModel(mMovieCatalogueRepository) as T
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) ->
                DetailMovieViewModel(mMovieCatalogueRepository) as T
            modelClass.isAssignableFrom(DetailTVShowViewModel::class.java) ->
                DetailTVShowViewModel(mMovieCatalogueRepository) as T
            modelClass.isAssignableFrom(FavoriteMoviesViewModel::class.java) ->
                FavoriteMoviesViewModel(mMovieCatalogueRepository) as T
            modelClass.isAssignableFrom(FavoriteTVShowsViewModel::class.java) ->
                FavoriteTVShowsViewModel(mMovieCatalogueRepository) as T
            else -> throw Throwable("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}