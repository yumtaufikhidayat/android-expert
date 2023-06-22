package com.yumtaufikhidayat.tourismappflow.core.data.source.remote

import com.yumtaufikhidayat.tourismappflow.core.data.source.remote.network.ApiResponse
import com.yumtaufikhidayat.tourismappflow.core.data.source.remote.network.ApiService
import com.yumtaufikhidayat.tourismappflow.core.data.source.remote.response.TourismResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource private constructor(
    private val apiService: ApiService
) {

    fun getAllTourism(): Flow<ApiResponse<List<TourismResponse>>> {
        // get data from remote api
        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.places
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.places))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }
}