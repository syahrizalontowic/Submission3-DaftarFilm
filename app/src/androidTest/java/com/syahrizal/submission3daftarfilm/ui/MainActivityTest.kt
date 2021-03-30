package com.syahrizal.submission3daftarfilm.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.syahrizal.submission3daftarfilm.R
import com.syahrizal.submission3daftarfilm.ui.activities.MainActivity
import com.syahrizal.submission3daftarfilm.utils.DataDummy.generateDummyTVShows
import com.syahrizal.submission3daftarfilm.utils.EspressoIdlingResource.espressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    private val dummyTvShows = generateDummyTVShows()

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(espressoIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(espressoIdlingResource)
    }

    @Test
    fun loadMovies() {
        Espresso.onView(withId(R.id.navigation_home))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))
    }

    @Test
    fun loadDetailMovie() {
        Espresso.onView(withId(R.id.rv_movie))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
        Espresso.onView(withId(R.id.sv_detail_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.riv_item_poster_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_movie_title_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_year_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_release_date_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_genres_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_popularity_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_score_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_tagLine_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_overview_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.sv_detail_movie)).perform(ViewActions.swipeUp())
        Espresso.onView(withId(R.id.tv_item_production_companies_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shareMovie() {
        Espresso.onView(withId(R.id.rv_movie))
            .perform(
                RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click())
            )
        Espresso.onView(withId(R.id.app_bar_share))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.app_bar_share))
            .check(ViewAssertions.matches(ViewMatchers.isClickable()))
        Espresso.onView(withId(R.id.app_bar_share)).perform(ViewActions.click())
    }

    @Test
    fun loadTVShows() {
        Espresso.onView(ViewMatchers.withText("TV Shows")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_tv_show))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))
    }

    @Test
    fun loadDetailTVShow() {
        Espresso.onView(ViewMatchers.withText("TV Shows")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_show))
            .perform(
                RecyclerViewActions
                    .scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size)
            )
        Espresso.onView(withId(R.id.rv_tv_show))
            .perform(
                RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        dummyTvShows.size,
                        ViewActions.click()
                    )
            )
        Espresso.onView(withId(R.id.sv_detail_tv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.riv_item_poster_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_tv_show_name_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_first_air_date_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_genres_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_popularity_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_score_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_tagLine_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_overview_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.sv_detail_tv_show)).perform(ViewActions.swipeUp())
        Espresso.onView(withId(R.id.tv_item_production_companies_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun shareTVShow() {
        Espresso.onView(ViewMatchers.withText("TV Shows")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_show))
            .perform(
                RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(2, ViewActions.click())
            )
        Espresso.onView(withId(R.id.app_bar_share))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.app_bar_share))
            .check(ViewAssertions.matches(ViewMatchers.isClickable()))
        Espresso.onView(withId(R.id.app_bar_share)).perform(ViewActions.click())
    }

    @Test
    fun loadFavoriteMovies() {
        Espresso.onView(withId(R.id.rv_movie))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
        Espresso.onView(withId(R.id.app_bar_favorite))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.app_bar_favorite))
            .check(ViewAssertions.matches(ViewMatchers.isClickable()))
        Espresso.onView(withId(R.id.app_bar_favorite)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Espresso.onView(withId(R.id.navigation_favorites))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.navigation_favorites)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_favorite_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_favorite_movie))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
        Espresso.onView(withId(R.id.riv_item_poster_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_movie_title_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_year_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_release_date_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_genres_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_popularity_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_score_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_tagLine_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_overview_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.sv_detail_movie)).perform(ViewActions.swipeUp())
        Espresso.onView(withId(R.id.tv_item_production_companies_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.app_bar_favorite)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun loadFavoriteTvShows() {
        Espresso.onView(ViewMatchers.withText("TV Shows")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_show))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(2))
        Espresso.onView(withId(R.id.rv_tv_show))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    2,
                    ViewActions.click()
                )
            )
        Espresso.onView(withId(R.id.app_bar_favorite)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Espresso.onView(withId(R.id.navigation_favorites)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("TV Shows")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_favorite_tv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_favorite_tv_show))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
        Espresso.onView(withId(R.id.riv_item_poster_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_tv_show_name_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_first_air_date_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_genres_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_popularity_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_score_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_tagLine_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_item_overview_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.sv_detail_tv_show)).perform(ViewActions.swipeUp())
        Espresso.onView(withId(R.id.tv_item_production_companies_received))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.app_bar_favorite)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun checkRadioButtonFavoriteMovies() {
        Espresso.onView(withId(R.id.navigation_favorites)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rg_sort_fav_movie_items))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rb_sort_by_title_asc))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rb_sort_by_title_asc))
            .check(ViewAssertions.matches(ViewMatchers.isClickable()))
        Espresso.onView(withId(R.id.rb_sort_by_title_asc)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rb_sort_by_title_asc))
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))
        Espresso.onView(withId(R.id.rb_sort_by_title_desc))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rb_sort_by_title_desc))
            .check(ViewAssertions.matches(ViewMatchers.isClickable()))
        Espresso.onView(withId(R.id.rb_sort_by_title_desc)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rb_sort_by_title_desc))
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))
        Espresso.onView(withId(R.id.rb_sort_fav_movies_by_newest))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rb_sort_fav_movies_by_newest))
            .check(ViewAssertions.matches(ViewMatchers.isClickable()))
        Espresso.onView(withId(R.id.rb_sort_fav_movies_by_newest)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rb_sort_fav_movies_by_newest))
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))
        Espresso.onView(withId(R.id.rb_sort_fav_movies_by_oldest))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rb_sort_fav_movies_by_oldest))
            .check(ViewAssertions.matches(ViewMatchers.isClickable()))
        Espresso.onView(withId(R.id.rb_sort_fav_movies_by_oldest)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rb_sort_fav_movies_by_oldest))
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))
    }

    @Test
    fun checkRadioButtonFavoriteTvShows() {
        Espresso.onView(withId(R.id.navigation_favorites)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("TV Shows")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rg_sort_fav_tv_show_items))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rb_sort_by_name_asc))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rb_sort_by_name_asc))
            .check(ViewAssertions.matches(ViewMatchers.isClickable()))
        Espresso.onView(withId(R.id.rb_sort_by_name_asc)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rb_sort_by_name_asc))
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))
        Espresso.onView(withId(R.id.rb_sort_by_name_desc))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rb_sort_by_name_desc))
            .check(ViewAssertions.matches(ViewMatchers.isClickable()))
        Espresso.onView(withId(R.id.rb_sort_by_name_desc)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rb_sort_by_name_desc))
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))
        Espresso.onView(withId(R.id.rb_sort_fav_tv_shows_by_newest))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rb_sort_fav_tv_shows_by_newest))
            .check(ViewAssertions.matches(ViewMatchers.isClickable()))
        Espresso.onView(withId(R.id.rb_sort_fav_tv_shows_by_newest)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rb_sort_fav_tv_shows_by_newest))
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))
        Espresso.onView(withId(R.id.rb_sort_fav_tv_shows_by_oldest))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rb_sort_fav_tv_shows_by_oldest))
            .check(ViewAssertions.matches(ViewMatchers.isClickable()))
        Espresso.onView(withId(R.id.rb_sort_fav_tv_shows_by_oldest)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rb_sort_fav_tv_shows_by_oldest))
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))
    }
}
