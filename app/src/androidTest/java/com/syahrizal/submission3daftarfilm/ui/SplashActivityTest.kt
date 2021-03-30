package com.syahrizal.submission3daftarfilm.ui

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.syahrizal.submission3daftarfilm.R
import com.syahrizal.submission3daftarfilm.ui.activities.SplashActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SplashActivityTest {

    @Before
    fun setUp() {
        ActivityScenario.launch(SplashActivity::class.java)
    }

    @Test
    fun loadSplashScreen() {
        onView(withId(R.id.riv_zfilm)).check(matches(isDisplayed()))
        onView(withText("v. 1.0")).check(matches(isDisplayed()))
        onView(withText("DAFTAR FILM")).check(matches(isDisplayed()))
    }
}