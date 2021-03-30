package com.syahrizal.submission3daftarfilm.ui.home.callback

import com.syahrizal.submission3daftarfilm.data.source.local.entity.TVShowEntity

interface OnTVShowItemClickCallback {
    fun onItemClicked(data: TVShowEntity)
    fun onItemShared(data: TVShowEntity)
}
