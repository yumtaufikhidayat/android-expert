package com.yumtaufikhidayat.tourismappflow

import android.app.Application
import com.yumtaufikhidayat.tourismappflow.core.di.CoreComponent
import com.yumtaufikhidayat.tourismappflow.core.di.DaggerCoreComponent
import com.yumtaufikhidayat.tourismappflow.di.AppComponent
import com.yumtaufikhidayat.tourismappflow.di.DaggerAppComponent

open class MyApplication : Application() {
    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}