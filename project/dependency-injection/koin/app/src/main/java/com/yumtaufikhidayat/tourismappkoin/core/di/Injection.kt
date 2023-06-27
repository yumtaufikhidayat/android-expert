package com.yumtaufikhidayat.tourismappkoin.core.di

import android.content.Context
import com.yumtaufikhidayat.tourismappkoin.core.data.TourismRepository
import com.yumtaufikhidayat.tourismappkoin.core.data.source.local.LocalDataSource
import com.yumtaufikhidayat.tourismappkoin.core.data.source.local.room.TourismDatabase
import com.yumtaufikhidayat.tourismappkoin.core.data.source.remote.RemoteDataSource
import com.yumtaufikhidayat.tourismappkoin.core.data.source.remote.network.ApiConfig
import com.yumtaufikhidayat.tourismappkoin.core.domain.repository.ITourismRepository
import com.yumtaufikhidayat.tourismappkoin.core.domain.usecase.TourismInteractor
import com.yumtaufikhidayat.tourismappkoin.core.domain.usecase.TourismUseCase
import com.yumtaufikhidayat.tourismappkoin.core.utils.AppExecutors

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