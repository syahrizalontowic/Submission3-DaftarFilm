package com.syahrizal.submission3daftarfilm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.syahrizal.submission3daftarfilm.data.MovieCatalogueRepository
import com.syahrizal.submission3daftarfilm.data.source.local.entity.MovieEntity

class FavoriteMoviesViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {

    fun getFavoriteMovies(sort: String): LiveData<PagedList<MovieEntity>> =
        movieCatalogueRepository.getFavoredMovies(sort)
}