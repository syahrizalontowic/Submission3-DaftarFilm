package com.syahrizal.submission3daftarfilm.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.syahrizal.submission3daftarfilm.data.source.local.LocalDataSource
import com.syahrizal.submission3daftarfilm.data.source.local.entity.MovieEntity
import com.syahrizal.submission3daftarfilm.data.source.local.entity.TVShowEntity
import com.syahrizal.submission3daftarfilm.data.source.remote.ApiResponse
import com.syahrizal.submission3daftarfilm.data.source.remote.RemoteDataSource
import com.syahrizal.submission3daftarfilm.data.source.remote.response.movie.DetailMovieResponse
import com.syahrizal.submission3daftarfilm.data.source.remote.response.tvshow.DetailTVShowResponse
import com.syahrizal.submission3daftarfilm.data.source.remote.response.movie.MoviesItemResponse
import com.syahrizal.submission3daftarfilm.data.source.remote.response.tvshow.TVShowsItemResponse
import com.syahrizal.submission3daftarfilm.helper.ListToStringHelper.movieGenreListToStringConverter
import com.syahrizal.submission3daftarfilm.helper.ListToStringHelper.movieProductionCompanyListToStringConverter
import com.syahrizal.submission3daftarfilm.helper.ListToStringHelper.tvShowGenreListToStringConverter
import com.syahrizal.submission3daftarfilm.helper.ListToStringHelper.tvShowProductionCompanyListToStringConverter
import com.syahrizal.submission3daftarfilm.utils.AppExecutors
import com.syahrizal.submission3daftarfilm.vo.Resource
import kotlin.math.roundToInt

class MovieCatalogueRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    MovieCatalogueDataSource {

    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                MovieCatalogueRepository(remoteData, localData, appExecutors).apply {
                    instance = this
                }
            }
    }

    override fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>,
                List<MoviesItemResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()
                return LivePagedListBuilder(localDataSource.getMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean = data.isNullOrEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MoviesItemResponse>>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(data: List<MoviesItemResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = with(response) {
                        MovieEntity(
                            id,
                            posterPath,
                            title,
                            releaseDate,
                            "",
                            popularity,
                            0,
                            "",
                            overview,
                            "",
                            false
                        )
                    }
                    movieList.add(movie)
                }
                Log.d("MovieResponse", "$movieList")
                localDataSource.insertMovies(movieList)
                Log.d("MovieCatalogueRepo", "$localDataSource")
            }
        }.asLiveData()
    }

    override fun getTvShows(): LiveData<Resource<PagedList<TVShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TVShowEntity>,
                List<TVShowsItemResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TVShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()
                return LivePagedListBuilder(localDataSource.getTVShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TVShowEntity>?): Boolean = data.isNullOrEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TVShowsItemResponse>>> =
                remoteDataSource.getTvShows()

            override fun saveCallResult(data: List<TVShowsItemResponse>) {
                val tvShowList = ArrayList<TVShowEntity>()
                data.forEach {
                    val tvShow = with(it) {
                        TVShowEntity(
                            id,
                            posterPath,
                            name,
                            firstAirDate,
                            "",
                            popularity,
                            0,
                            "",
                            overview,
                            "",
                            false
                        )
                    }
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTVShows(tvShowList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(movieId: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, DetailMovieResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getDetailMovie(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean = data?.genres.isNullOrEmpty()

            override fun createCall(): LiveData<ApiResponse<DetailMovieResponse>> =
                remoteDataSource.getDetailMovie(movieId)

            override fun saveCallResult(data: DetailMovieResponse) {
                val detailMovieEntity = with(data) {
                    MovieEntity(
                        id,
                        posterPath,
                        title,
                        releaseDate,
                        movieGenreListToStringConverter(data),
                        popularity,
                        (voteAverage * 10).roundToInt(),
                        tagline,
                        overview,
                        movieProductionCompanyListToStringConverter(data),
                        false
                    )
                }
                localDataSource.insertDetailMovie(detailMovieEntity)
            }
        }.asLiveData()
    }

    override fun getDetailTVShow(tvId: Int): LiveData<Resource<TVShowEntity>> {
        return object : NetworkBoundResource<TVShowEntity, DetailTVShowResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<TVShowEntity> =
                localDataSource.getDetailTVShow(tvId)

            override fun shouldFetch(data: TVShowEntity?): Boolean = data?.genres.isNullOrEmpty()

            override fun createCall(): LiveData<ApiResponse<DetailTVShowResponse>> =
                remoteDataSource.getDetailTVShow(tvId)

            override fun saveCallResult(data: DetailTVShowResponse) {
                val detailTvShowEntity = with(data) {
                    TVShowEntity(
                        id,
                        posterPath,
                        name,
                        firstAirDate,
                        tvShowGenreListToStringConverter(data),
                        popularity,
                        (voteAverage * 10).roundToInt(),
                        tagline,
                        overview,
                        tvShowProductionCompanyListToStringConverter(data),
                        false
                    )
                }
                localDataSource.insertDetailTVShow(detailTvShowEntity)
            }
        }.asLiveData()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }

    override fun setFavoriteTVShow(tvShow: TVShowEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setTVShowFavorite(tvShow, state) }

    override fun getFavoredMovies(sort: String): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(5)
            .setPageSize(5)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoredMovies(sort), config).build()
    }

    override fun getFavoredTVShows(sort: String): LiveData<PagedList<TVShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(5)
            .setPageSize(5)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoredTVShows(sort), config).build()
    }
}
