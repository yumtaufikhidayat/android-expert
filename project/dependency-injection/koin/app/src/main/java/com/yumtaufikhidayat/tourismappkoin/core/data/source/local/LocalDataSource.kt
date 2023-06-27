package com.yumtaufikhidayat.tourismappkoin.core.data.source.local

import com.yumtaufikhidayat.tourismappkoin.core.data.source.local.entity.TourismEntity
import com.yumtaufikhidayat.tourismappkoin.core.data.source.local.room.TourismDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource private constructor(private val tourismDao: TourismDao){

    fun getAllTourism(): Flow<List<TourismEntity>> = tourismDao.getAllTourism()

    fun getFavoriteTourism(): Flow<List<TourismEntity>> = tourismDao.getFavoriteTourism()

    suspend fun insertTourism(tourismList: List<TourismEntity>) = tourismDao.insertTourism(tourismList)

    fun setFavoriteTourism(tourism: TourismEntity, newState: Boolean) {
        tourism.isFavorite = newState
        tourismDao.updateFavoriteTourism(tourism)
    }

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(tourismDao: TourismDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(tourismDao)
            }
    }
}