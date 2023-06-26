package com.yumtaufikhidayat.myapplication

import android.app.Application
import com.yumtaufikhidayat.myapplication.di.StorageModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(StorageModule.storageModule)
        }
    }
}