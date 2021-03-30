package com.syahrizal.submission3daftarfilm.data.source.remote.response.movie

import com.google.gson.annotations.SerializedName

data class MovieGenresItemResponse(

    @field:SerializedName("name")
    val name: String
)
