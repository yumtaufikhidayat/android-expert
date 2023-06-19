package com.yumtaufikhidayat.tourismappcleanarchitecture.home

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.tourismappcleanarchitecture.core.domain.usecase.TourismUseCase

class HomeViewModel(
    tourismUseCase: TourismUseCase
) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism()
}