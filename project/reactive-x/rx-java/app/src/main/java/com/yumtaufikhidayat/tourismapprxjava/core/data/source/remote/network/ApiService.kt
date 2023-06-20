package com.yumtaufikhidayat.tourismapprxjava.core.data.source.remote.network

import com.yumtaufikhidayat.tourismapprxjava.core.data.source.remote.response.ListTourismResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiService {

    @GET(UrlEndpoint.GET_LIST)
    fun getList(): Flowable<ListTourismResponse>
}