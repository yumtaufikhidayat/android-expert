package com.yumtaufikhidayat.tourismappflow.di

import com.yumtaufikhidayat.tourismappflow.core.domain.usecase.TourismInteractor
import com.yumtaufikhidayat.tourismappflow.core.domain.usecase.TourismUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideTourismUseCase(tourismInteractor: TourismInteractor): TourismUseCase
}