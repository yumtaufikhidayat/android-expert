package com.yumtaufikhidayat.tourismappflow.core.domain.usecase

import androidx.lifecycle.LiveData
import com.yumtaufikhidayat.tourismappflow.core.data.Resource
import com.yumtaufikhidayat.tourismappflow.core.domain.model.Tourism

interface TourismUseCase {

    fun getAllTourism(): LiveData<Resource<List<Tourism>>>

    fun getFavoriteTourism(): LiveData<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}