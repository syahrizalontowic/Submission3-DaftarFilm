package com.syahrizal.submission3daftarfilm.data.source.remote.response.movie

import com.google.gson.annotations.SerializedName

data class MoviesItemResponse(

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("release_date")
    val releaseDate: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("popularity")
    val popularity: Double
)
