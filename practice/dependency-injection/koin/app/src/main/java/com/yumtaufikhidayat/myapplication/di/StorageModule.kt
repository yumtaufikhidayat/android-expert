package com.yumtaufikhidayat.myapplication.di

import com.yumtaufikhidayat.myapplication.SessionManager
import com.yumtaufikhidayat.myapplication.UserRepository
import org.koin.dsl.module

object StorageModule {
    val storageModule = module {
        factory {
            SessionManager(get())
        }

        factory {
            UserRepository(get())
        }
    }
}