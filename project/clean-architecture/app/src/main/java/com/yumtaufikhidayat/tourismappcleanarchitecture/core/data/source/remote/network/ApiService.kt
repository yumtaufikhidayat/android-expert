package com.yumtaufikhidayat.tourismappcleanarchitecture.core.data.source.remote.network

import com.yumtaufikhidayat.tourismappcleanarchitecture.core.data.source.remote.response.ListTourismResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET(UrlEndpoint.GET_LIST)
    fun getList(): Call<ListTourismResponse>
}