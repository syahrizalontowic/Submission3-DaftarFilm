package com.syahrizal.submission3daftarfilm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.syahrizal.submission3daftarfilm.data.MovieCatalogueRepository
import com.syahrizal.submission3daftarfilm.data.source.local.entity.TVShowEntity
import com.syahrizal.submission3daftarfilm.vo.Resource

class DetailTVShowViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {

    private var tvId = MutableLiveData<Int>()

    fun setSelectedTVShow(tvId: Int) {
        this.tvId.value = tvId
    }

    var detailTvShow: LiveData<Resource<TVShowEntity>> = Transformations.switchMap(tvId) {
        movieCatalogueRepository.getDetailTVShow(it)
    }

    fun setFavorite() {
        val detailTvShowResource = detailTvShow.value
        if (detailTvShowResource != null) {
            val detailTvShow = detailTvShowResource.data
            if (detailTvShow != null) {
                val newState = !detailTvShow.isFavorite
                movieCatalogueRepository.setFavoriteTVShow(detailTvShow, newState)
            }
        }
    }
}