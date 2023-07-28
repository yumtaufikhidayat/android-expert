package com.yumtaufikhidayat

import android.app.Application
import com.yumtaufikhidayat.mysimplelogin.di.AppComponent
import com.yumtaufikhidayat.mysimplelogin.di.DaggerAppComponent

open class MyApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(
            applicationContext
        )
    }
}