package com.yumtaufikhidayat.tourismappkoin.core.domain.repository

import com.yumtaufikhidayat.tourismappkoin.core.data.Resource
import com.yumtaufikhidayat.tourismappkoin.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface ITourismRepository {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}