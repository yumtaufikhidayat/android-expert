package com.yumtaufikhidayat.tourismappkoin.core.data.source.remote.network

import com.yumtaufikhidayat.tourismappkoin.core.data.source.remote.response.ListTourismResponse
import retrofit2.http.GET

interface ApiService {

    @GET(UrlEndpoint.GET_LIST)
    suspend fun getList(): ListTourismResponse
}