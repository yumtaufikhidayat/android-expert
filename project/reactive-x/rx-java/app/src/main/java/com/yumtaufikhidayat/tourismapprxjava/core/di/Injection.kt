package com.yumtaufikhidayat.tourismapprxjava.core.di

import android.content.Context
import com.yumtaufikhidayat.tourismapprxjava.core.data.TourismRepository
import com.yumtaufikhidayat.tourismapprxjava.core.data.source.local.LocalDataSource
import com.yumtaufikhidayat.tourismapprxjava.core.data.source.local.room.TourismDatabase
import com.yumtaufikhidayat.tourismapprxjava.core.data.source.remote.RemoteDataSource
import com.yumtaufikhidayat.tourismapprxjava.core.data.source.remote.network.ApiConfig
import com.yumtaufikhidayat.tourismapprxjava.core.domain.repository.ITourismRepository
import com.yumtaufikhidayat.tourismapprxjava.core.domain.repository.TourismInteractor
import com.yumtaufikhidayat.tourismapprxjava.core.domain.usecase.TourismUseCase
import com.yumtaufikhidayat.tourismapprxjava.core.utils.AppExecutors

object Injection {
    private fun provideRepository(context: Context): ITourismRepository {
        val database = TourismDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTourismUseCase(context: Context): TourismUseCase {
        val repository = provideRepository(context)
        return TourismInteractor(repository)
    }
}