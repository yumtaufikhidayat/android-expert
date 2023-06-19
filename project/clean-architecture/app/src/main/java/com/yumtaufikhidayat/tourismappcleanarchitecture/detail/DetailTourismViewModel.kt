package com.yumtaufikhidayat.tourismappcleanarchitecture.detail

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.tourismappcleanarchitecture.core.domain.model.Tourism
import com.yumtaufikhidayat.tourismappcleanarchitecture.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(
    private val tourismUseCase: TourismUseCase
) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus: Boolean) {
        tourismUseCase.setFavoriteTourism(tourism, newStatus)
    }
}