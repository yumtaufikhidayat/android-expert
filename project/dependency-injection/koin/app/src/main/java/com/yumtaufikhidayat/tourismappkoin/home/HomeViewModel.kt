package com.yumtaufikhidayat.tourismappkoin.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.yumtaufikhidayat.tourismappkoin.core.domain.usecase.TourismUseCase

class HomeViewModel(
    tourismUseCase: TourismUseCase
) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
}