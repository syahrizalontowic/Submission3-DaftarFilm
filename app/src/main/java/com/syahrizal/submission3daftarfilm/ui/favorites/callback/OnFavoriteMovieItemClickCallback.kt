package com.syahrizal.submission3daftarfilm.ui.favorites.callback

import com.syahrizal.submission3daftarfilm.data.source.local.entity.MovieEntity


interface OnFavoriteMovieItemClickCallback {
    fun onItemClicked(data: MovieEntity)
    fun onItemShared(data: MovieEntity)
}
