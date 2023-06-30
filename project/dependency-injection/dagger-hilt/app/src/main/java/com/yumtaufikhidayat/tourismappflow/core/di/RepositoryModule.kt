package com.yumtaufikhidayat.tourismappflow.core.di

import com.yumtaufikhidayat.tourismappflow.core.data.TourismRepository
import com.yumtaufikhidayat.tourismappflow.core.domain.repository.ITourismRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(tourismRepository: TourismRepository): ITourismRepository

}