package com.yumtaufikhidayat.tourismappflow.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yumtaufikhidayat.tourismappflow.core.ui.ViewModelFactory
import com.yumtaufikhidayat.tourismappflow.detail.DetailTourismViewModel
import com.yumtaufikhidayat.tourismappflow.di.ViewModelKey
import com.yumtaufikhidayat.tourismappflow.favorite.FavoriteViewModel
import com.yumtaufikhidayat.tourismappflow.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    abstract fun bindFavoriteViewModel(viewModel: FavoriteViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailTourismViewModel::class)
    abstract fun bindDetailTourismViewModel(viewModel: DetailTourismViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}