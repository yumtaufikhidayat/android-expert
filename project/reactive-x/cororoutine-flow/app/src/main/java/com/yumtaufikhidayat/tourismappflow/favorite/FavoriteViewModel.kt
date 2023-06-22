package com.yumtaufikhidayat.tourismappflow.favorite

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.tourismappflow.core.domain.usecase.TourismUseCase

class FavoriteViewModel(
    tourismUseCase: TourismUseCase
) : ViewModel() {
    val favoriteTourism = tourismUseCase.getFavoriteTourism()
}