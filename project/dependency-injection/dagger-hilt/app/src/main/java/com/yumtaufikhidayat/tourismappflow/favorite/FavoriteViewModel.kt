package com.yumtaufikhidayat.tourismappflow.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.yumtaufikhidayat.tourismappflow.core.domain.usecase.TourismUseCase
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
    tourismUseCase: TourismUseCase
) : ViewModel() {
    val favoriteTourism = tourismUseCase.getFavoriteTourism().asLiveData()
}