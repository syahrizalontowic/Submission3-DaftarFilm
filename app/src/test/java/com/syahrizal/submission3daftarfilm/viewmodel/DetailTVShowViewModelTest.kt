package com.syahrizal.submission3daftarfilm.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.syahrizal.submission3daftarfilm.data.MovieCatalogueRepository
import com.syahrizal.submission3daftarfilm.data.source.local.entity.TVShowEntity
import com.syahrizal.submission3daftarfilm.utils.DataDummy.generateDummyDetailTVShow
import com.syahrizal.submission3daftarfilm.utils.DataDummy.generateDummyTVShows
import com.syahrizal.submission3daftarfilm.vo.Resource
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTVShowViewModelTest {

    private lateinit var viewModel: DetailTVShowViewModel
    private val dummyTvShows = generateDummyTVShows()[2]
    private val tvId = dummyTvShows.id
    private val dummyDetailTvShow = generateDummyDetailTVShow(tvId as Int)[2]

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var detailTvShowObserver: Observer<Resource<TVShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailTVShowViewModel(movieCatalogueRepository)
        tvId?.let { viewModel.setSelectedTVShow(it) }
    }

    @Test
    fun getDetailTVShow() {
        val dummyDetailTvShow = Resource.success(dummyDetailTvShow)
        val detailTvShow = MutableLiveData<Resource<TVShowEntity>>()
        detailTvShow.value = dummyDetailTvShow
        `when`(movieCatalogueRepository.getDetailTVShow(tvId as Int)).thenReturn(detailTvShow)
        viewModel.detailTvShow.observeForever(detailTvShowObserver)
        assertNotNull(dummyDetailTvShow.data)
        verify(detailTvShowObserver).onChanged(dummyDetailTvShow)
    }
}


