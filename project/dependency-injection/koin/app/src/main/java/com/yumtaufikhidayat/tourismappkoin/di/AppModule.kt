package com.yumtaufikhidayat.tourismappkoin.di

import com.yumtaufikhidayat.tourismappkoin.core.domain.usecase.TourismInteractor
import com.yumtaufikhidayat.tourismappkoin.core.domain.usecase.TourismUseCase
import com.yumtaufikhidayat.tourismappkoin.detail.DetailTourismViewModel
import com.yumtaufikhidayat.tourismappkoin.favorite.FavoriteViewModel
import com.yumtaufikhidayat.tourismappkoin.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TourismUseCase> { TourismInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailTourismViewModel(get()) }
}