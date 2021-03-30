package com.syahrizal.submission3daftarfilm.ui.favorites.callback

import com.syahrizal.submission3daftarfilm.data.source.local.entity.TVShowEntity

interface OnFavoriteTVShowItemClickCallback {
    fun onItemClicked(data: TVShowEntity)
    fun onItemShared(data: TVShowEntity)
}
