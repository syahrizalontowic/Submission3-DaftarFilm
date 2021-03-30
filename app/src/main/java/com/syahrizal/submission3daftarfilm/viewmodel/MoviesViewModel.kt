package com.syahrizal.submission3daftarfilm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.syahrizal.submission3daftarfilm.data.MovieCatalogueRepository
import com.syahrizal.submission3daftarfilm.data.source.local.entity.MovieEntity
import com.syahrizal.submission3daftarfilm.vo.Resource

class MoviesViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {

    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> =
        movieCatalogueRepository.getMovies()
}