package com.syahrizal.submission3daftarfilm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.syahrizal.submission3daftarfilm.data.MovieCatalogueRepository
import com.syahrizal.submission3daftarfilm.data.source.local.entity.TVShowEntity
import com.syahrizal.submission3daftarfilm.vo.Resource

class TVShowsViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {

    fun getTvShows(): LiveData<Resource<PagedList<TVShowEntity>>> =
        movieCatalogueRepository.getTvShows()
}