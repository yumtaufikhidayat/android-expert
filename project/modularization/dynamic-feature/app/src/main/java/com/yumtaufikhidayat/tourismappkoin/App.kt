package com.yumtaufikhidayat.tourismappkoin

import android.app.Application
import com.yumtaufikhidayat.tourismapp.core.di.databaseModule
import com.yumtaufikhidayat.tourismapp.core.di.networkModule
import com.yumtaufikhidayat.tourismapp.core.di.repositoryModule
import com.yumtaufikhidayat.tourismappkoin.di.useCaseModule
import com.yumtaufikhidayat.tourismappkoin.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}