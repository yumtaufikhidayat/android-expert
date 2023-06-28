package com.yumtaufikhidayat.tourismappflow.core.domain.usecase

import com.yumtaufikhidayat.tourismappflow.core.data.Resource
import com.yumtaufikhidayat.tourismappflow.core.domain.model.Tourism
import com.yumtaufikhidayat.tourismappflow.core.domain.repository.ITourismRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TourismInteractor @Inject constructor(private val tourismRepository: ITourismRepository) : TourismUseCase {
    override fun getAllTourism(): Flow<Resource<List<Tourism>>> {
        return tourismRepository.getAllTourism()
    }

    override fun getFavoriteTourism(): Flow<List<Tourism>> {
        return tourismRepository.getFavoriteTourism()
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        return tourismRepository.setFavoriteTourism(tourism, state)
    }
}