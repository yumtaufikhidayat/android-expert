package com.yumtaufikhidayat.tourismapp.core.data

import com.yumtaufikhidayat.tourismapp.core.data.source.local.LocalDataSource
import com.yumtaufikhidayat.tourismapp.core.data.source.remote.RemoteDataSource
import com.yumtaufikhidayat.tourismapp.core.data.source.remote.network.ApiResponse
import com.yumtaufikhidayat.tourismapp.core.data.source.remote.response.TourismResponse
import com.yumtaufikhidayat.tourismapp.core.domain.model.Tourism
import com.yumtaufikhidayat.tourismapp.core.domain.repository.ITourismRepository
import com.yumtaufikhidayat.tourismapp.core.utils.AppExecutors
import com.yumtaufikhidayat.tourismapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TourismRepository constructor (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ITourismRepository {
    override fun getAllTourism(): Flow<com.yumtaufikhidayat.tourismapp.core.data.Resource<List<Tourism>>> =
        object : com.yumtaufikhidayat.tourismapp.core.data.NetworkBoundResource<List<Tourism>, List<TourismResponse>>(appExecutors) {
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
        private var instance: com.yumtaufikhidayat.tourismapp.core.data.TourismRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: com.yumtaufikhidayat.tourismapp.core.data.source.local.LocalDataSource,
            appExecutors: AppExecutors
        ): com.yumtaufikhidayat.tourismapp.core.data.TourismRepository =
            com.yumtaufikhidayat.tourismapp.core.data.TourismRepository.Companion.instance ?: synchronized(this) {
                com.yumtaufikhidayat.tourismapp.core.data.TourismRepository.Companion.instance
                    ?: com.yumtaufikhidayat.tourismapp.core.data.TourismRepository(
                        remoteData,
                        localData,
                        appExecutors
                    )
            }
    }
}