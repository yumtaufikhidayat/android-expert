package com.yumtaufikhidayat.tourismappcleanarchitecture.favorite

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.tourismappcleanarchitecture.core.domain.usecase.TourismUseCase

class FavoriteViewModel(
    tourismUseCase: TourismUseCase
) : ViewModel() {
    val favoriteTourism = tourismUseCase.getFavoriteTourism()
}