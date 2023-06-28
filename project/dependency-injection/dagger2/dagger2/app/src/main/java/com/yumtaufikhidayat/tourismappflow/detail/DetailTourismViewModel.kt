package com.yumtaufikhidayat.tourismappflow.detail

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.tourismappflow.core.domain.model.Tourism
import com.yumtaufikhidayat.tourismappflow.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(
    private val tourismUseCase: TourismUseCase
) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus: Boolean) {
        tourismUseCase.setFavoriteTourism(tourism, newStatus)
    }
}