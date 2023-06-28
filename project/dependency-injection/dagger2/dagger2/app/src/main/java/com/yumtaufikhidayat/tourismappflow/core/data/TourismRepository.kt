package com.yumtaufikhidayat.tourismappflow.core.data

import com.yumtaufikhidayat.tourismappcleanarchitecture.core.utils.DataMapper
import com.yumtaufikhidayat.tourismappflow.core.data.source.local.LocalDataSource
import com.yumtaufikhidayat.tourismappflow.core.data.source.remote.RemoteDataSource
import com.yumtaufikhidayat.tourismappflow.core.data.source.remote.network.ApiResponse
import com.yumtaufikhidayat.tourismappflow.core.data.source.remote.response.TourismResponse
import com.yumtaufikhidayat.tourismappflow.core.domain.model.Tourism
import com.yumtaufikhidayat.tourismappflow.core.domain.repository.ITourismRepository
import com.yumtaufikhidayat.tourismappflow.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TourismRepository private constructor (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ITourismRepository {
    override fun getAllTourism(): Flow<Resource<List<Tourism>>> =
        object : NetworkBoundResource<List<Tourism>, List<TourismResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Tourism>> {
                return localDataSource.getAllTourism().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Tourism>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<TourismResponse>>> {
                return remoteDataSource.getAllTourism()
            }

            override suspend fun saveCallResult(data: List<TourismResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asFlow()

    override fun getFavoriteTourism(): Flow<List<Tourism>> {
        return localDataSource.getFavoriteTourism().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state)}
    }

    companion object {
        @Volatile
        private var instance: TourismRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): TourismRepository =
            instance ?: synchronized(this) {
                instance ?: TourismRepository(remoteData, localData, appExecutors)
            }
    }
}