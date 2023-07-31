package com.yumtaufikhidayat.tourismapp.core.domain.repository

import com.yumtaufikhidayat.tourismapp.core.data.Resource
import com.yumtaufikhidayat.tourismapp.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface ITourismRepository {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}