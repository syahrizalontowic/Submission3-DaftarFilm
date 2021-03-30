package com.syahrizal.submission3daftarfilm.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.syahrizal.submission3daftarfilm.data.MovieCatalogueRepository
import com.syahrizal.submission3daftarfilm.data.source.local.entity.MovieEntity
import com.syahrizal.submission3daftarfilm.helper.SortUtils.ASCENDING
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteMoviesViewModelTest {

    private lateinit var viewModel: FavoriteMoviesViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteMoviesViewModel(movieCatalogueRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyFavoriteMovies = pagedList
        `when`(dummyFavoriteMovies.size).thenReturn(5)
        val favoriteMovies = MutableLiveData<PagedList<MovieEntity>>()
        favoriteMovies.value = dummyFavoriteMovies
        `when`(movieCatalogueRepository.getFavoredMovies(ASCENDING)).thenReturn(favoriteMovies)
        val movieEntities = viewModel.getFavoriteMovies(ASCENDING).value
        verify(movieCatalogueRepository).getFavoredMovies(ASCENDING)
        assertNotNull(movieEntities)
        assertEquals(5, movieEntities?.size)
        viewModel.getFavoriteMovies(ASCENDING).observeForever(observer)
        verify(observer).onChanged(dummyFavoriteMovies)
    }
}