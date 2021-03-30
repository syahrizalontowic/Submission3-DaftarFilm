package com.syahrizal.submission3daftarfilm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.syahrizal.submission3daftarfilm.data.MovieCatalogueRepository
import com.syahrizal.submission3daftarfilm.data.source.local.entity.MovieEntity
import com.syahrizal.submission3daftarfilm.vo.Resource

class DetailMovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {

    private var movieId = MutableLiveData<Int>()

    fun setSelectedMovie(movieId: Int) {
        this.movieId.value = movieId
    }

    var detailMovie: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) {
        movieCatalogueRepository.getDetailMovie(it)
    }

    fun setFavorite() {
        val detailMovieResource = detailMovie.value
        if (detailMovieResource != null) {
            val detailMovie = detailMovieResource.data
            if (detailMovie != null) {
                val newState = !detailMovie.isFavorite
                movieCatalogueRepository.setFavoriteMovie(detailMovie, newState)
            }
        }
    }
}