package com.yumtaufikhidayat.mysimplelogin.di

import android.content.Context
import com.yumtaufikhidayat.mysimplelogin.ui.HomeActivity
import com.yumtaufikhidayat.mysimplelogin.ui.MainActivity
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