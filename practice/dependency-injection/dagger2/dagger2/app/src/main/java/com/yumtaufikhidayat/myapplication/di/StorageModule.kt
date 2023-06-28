package com.yumtaufikhidayat.myapplication.di

import android.content.Context
import com.yumtaufikhidayat.myapplication.SessionManager
import dagger.Module
import dagger.Provides

@Module
class StorageModule {
    @Provides
    fun provideSessionManager(context: Context): SessionManager = SessionManager(context)
}