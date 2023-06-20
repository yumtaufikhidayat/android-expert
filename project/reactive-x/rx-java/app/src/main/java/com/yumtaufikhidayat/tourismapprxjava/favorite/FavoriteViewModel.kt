package com.yumtaufikhidayat.tourismapprxjava.favorite

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.tourismapprxjava.core.domain.usecase.TourismUseCase

class FavoriteViewModel(
    tourismUseCase: TourismUseCase
) : ViewModel() {
    val favoriteTourism = LiveDataReactiveStreams.fromPublisher(tourismUseCase.getFavoriteTourism())
}