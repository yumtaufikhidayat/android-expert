package com.yumtaufikhidayat.tourismapprxjava.home

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.tourismapprxjava.core.domain.usecase.TourismUseCase

class HomeViewModel(
    tourismUseCase: TourismUseCase
) : ViewModel() {
    val tourism = LiveDataReactiveStreams.fromPublisher(tourismUseCase.getAllTourism())
}