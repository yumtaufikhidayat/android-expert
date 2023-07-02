package com.yumtaufikhidayat.tourismappkoin.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.yumtaufikhidayat.tourismappkoin.core.domain.usecase.TourismUseCase

class FavoriteViewModel(
    tourismUseCase: TourismUseCase
) : ViewModel() {
    val favoriteTourism = tourismUseCase.getFavoriteTourism().asLiveData()
}