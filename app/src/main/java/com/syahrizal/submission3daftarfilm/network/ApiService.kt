package com.syahrizal.submission3daftarfilm.network

import com.syahrizal.submission3daftarfilm.data.source.remote.response.movie.DetailMovieResponse
import com.syahrizal.submission3daftarfilm.data.source.remote.response.tvshow.DetailTVShowResponse
import com.syahrizal.submission3daftarfilm.data.source.remote.response.movie.MovieResponse
import com.syahrizal.submission3daftarfilm.data.source.remote.response.tvshow.TVShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("discover/{discoverPath}")
    fun getMovies(
        @Path("discoverPath") discoverPath: String,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("sort_by") sortBy: String,
        @Query("include_adult") include_adult: Boolean
    ): Call<MovieResponse>

    @GET("discover/{discoverPath}")
    fun getTvShows(
        @Path("discoverPath") discoverPath: String,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("sort_by") sortBy: String
    ): Call<TVShowResponse>

    @GET("movie/{movieId}")
    fun getDetailMovie(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<DetailMovieResponse>

    @GET("tv/{tvId}")
    fun getDetailTVShow(
        @Path("tvId") tvId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<DetailTVShowResponse>
}