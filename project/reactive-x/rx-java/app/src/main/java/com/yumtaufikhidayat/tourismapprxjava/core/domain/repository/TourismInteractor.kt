package com.yumtaufikhidayat.tourismapprxjava.core.domain.repository

import com.yumtaufikhidayat.tourismapprxjava.core.data.Resource
import com.yumtaufikhidayat.tourismapprxjava.core.domain.model.Tourism
import com.yumtaufikhidayat.tourismapprxjava.core.domain.usecase.TourismUseCase
import io.reactivex.Flowable

class TourismInteractor(private val tourismRepository: ITourismRepository) : TourismUseCase {
    override fun getAllTourism(): Flowable<Resource<List<Tourism>>> {
        return tourismRepository.getAllTourism()
    }

    override fun getFavoriteTourism(): Flowable<List<Tourism>> {
        return tourismRepository.getFavoriteTourism()
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        return tourismRepository.setFavoriteTourism(tourism, state)
    }
}