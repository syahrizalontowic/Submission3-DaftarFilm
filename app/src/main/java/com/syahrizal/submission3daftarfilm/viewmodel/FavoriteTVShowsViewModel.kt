package com.syahrizal.submission3daftarfilm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.syahrizal.submission3daftarfilm.data.MovieCatalogueRepository
import com.syahrizal.submission3daftarfilm.data.source.local.entity.TVShowEntity

class FavoriteTVShowsViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {

    fun getFavoriteTVShows(sort: String): LiveData<PagedList<TVShowEntity>> =
        movieCatalogueRepository.getFavoredTVShows(sort)
}