package com.yumtaufikhidayat.tourismappflow.di

import com.yumtaufikhidayat.tourismappflow.core.domain.usecase.TourismInteractor
import com.yumtaufikhidayat.tourismappflow.core.domain.usecase.TourismUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideTourismUseCase(tourismInteractor: TourismInteractor): TourismUseCase
}