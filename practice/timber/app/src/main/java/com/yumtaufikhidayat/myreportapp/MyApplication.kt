package com.yumtaufikhidayat.myreportapp

import android.app.Application
import com.google.firebase.BuildConfig
import com.yumtaufikhidayat.myreportapp.utils.ReleaseTree
import timber.log.Timber

open class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val timberPlant = if (BuildConfig.DEBUG) {
            Timber.DebugTree()
        } else {
            ReleaseTree()
        }
        Timber.plant(timberPlant)
    }
}