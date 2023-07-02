package com.yumtaufikhidayat.tourismappkoin.detail

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.tourismappkoin.core.domain.model.Tourism
import com.yumtaufikhidayat.tourismappkoin.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(
    private val tourismUseCase: TourismUseCase
) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus: Boolean) {
        tourismUseCase.setFavoriteTourism(tourism, newStatus)
    }
}