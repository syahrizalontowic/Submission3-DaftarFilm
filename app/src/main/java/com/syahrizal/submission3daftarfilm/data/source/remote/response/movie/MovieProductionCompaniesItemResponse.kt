package com.syahrizal.submission3daftarfilm.data.source.remote.response.movie

import com.google.gson.annotations.SerializedName

data class MovieProductionCompaniesItemResponse(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("origin_country")
    val originCountry: String
)
