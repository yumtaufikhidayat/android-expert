package com.yumtaufikhidayat.myapplication.di

import android.content.Context
import com.yumtaufikhidayat.myapplication.ui.HomeActivity
import com.yumtaufikhidayat.myapplication.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: HomeActivity)
}