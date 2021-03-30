package com.syahrizal.submission3daftarfilm.data.source.remote.response.tvshow

import com.google.gson.annotations.SerializedName

data class TVShowResponse(

    @field:SerializedName("results")
    val results: List<TVShowsItemResponse>
)
