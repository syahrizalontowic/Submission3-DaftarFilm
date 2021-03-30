package com.syahrizal.submission3daftarfilm.data.source.remote.response.tvshow

import com.google.gson.annotations.SerializedName

data class TVShowProductionCompaniesItemResponse(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("origin_country")
    val originCountry: String
)
