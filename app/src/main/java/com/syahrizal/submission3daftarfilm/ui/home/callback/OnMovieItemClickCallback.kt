package com.syahrizal.submission3daftarfilm.ui.home.callback

import com.syahrizal.submission3daftarfilm.data.source.local.entity.MovieEntity

interface OnMovieItemClickCallback {
    fun onItemClicked(data: MovieEntity)
    fun onItemShared(data: MovieEntity)
}
