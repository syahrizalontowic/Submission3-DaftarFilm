package com.syahrizal.submission3daftarfilm.data.source.local.room.dbinspector

import android.app.Application
import com.facebook.stetho.Stetho

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}