package com.yumtaufikhidayat.tourismappflow.home

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.tourismappflow.core.domain.usecase.TourismUseCase

class HomeViewModel(
    tourismUseCase: TourismUseCase
) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism()
}