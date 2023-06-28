package com.yumtaufikhidayat

import android.app.Application
import com.yumtaufikhidayat.myapplication.di.AppComponent
import com.yumtaufikhidayat.myapplication.di.DaggerAppComponent

open class MyApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(
            applicationContext
        )
    }
}