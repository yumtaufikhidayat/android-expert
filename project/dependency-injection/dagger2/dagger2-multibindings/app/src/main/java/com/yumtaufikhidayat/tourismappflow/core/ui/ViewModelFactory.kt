package com.yumtaufikhidayat.tourismappflow.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yumtaufikhidayat.tourismappflow.core.domain.usecase.TourismUseCase
import com.yumtaufikhidayat.tourismappflow.detail.DetailTourismViewModel
import com.yumtaufikhidayat.tourismappflow.favorite.FavoriteViewModel
import com.yumtaufikhidayat.tourismappflow.home.HomeViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val tourismUseCase: TourismUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(tourismUseCase) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(tourismUseCase) as T
            }
            modelClass.isAssignableFrom(DetailTourismViewModel::class.java) -> {
                DetailTourismViewModel(tourismUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}