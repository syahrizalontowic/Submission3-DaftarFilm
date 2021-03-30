package com.syahrizal.submission3daftarfilm.ui.favorites

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.syahrizal.submission3daftarfilm.R
import com.syahrizal.submission3daftarfilm.ui.favorites.movie.FavoriteMoviesFragment
import com.syahrizal.submission3daftarfilm.ui.favorites.tvshow.FavoriteTvShowsFragment


class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.tab_movies, R.string.tab_tv_shows)
    }

    override fun getCount(): Int = TAB_TITLES.size

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FavoriteMoviesFragment()
            1 -> FavoriteTvShowsFragment()
            else -> Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence =
        mContext.resources.getString(TAB_TITLES[position])
}