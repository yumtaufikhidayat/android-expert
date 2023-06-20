package com.yumtaufikhidayat.tourismapprxjava.detail

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.tourismapprxjava.core.domain.model.Tourism
import com.yumtaufikhidayat.tourismapprxjava.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(
    private val tourismUseCase: TourismUseCase
) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus: Boolean) {
        tourismUseCase.setFavoriteTourism(tourism, newStatus)
    }
}