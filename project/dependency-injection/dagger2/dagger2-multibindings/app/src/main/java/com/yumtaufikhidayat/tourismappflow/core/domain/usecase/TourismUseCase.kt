package com.yumtaufikhidayat.tourismappflow.core.domain.usecase

import com.yumtaufikhidayat.tourismappflow.core.data.Resource
import com.yumtaufikhidayat.tourismappflow.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface TourismUseCase {

    fun getAllTourism(): Flow<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}