package com.yumtaufikhidayat.tourismappcleanarchitecture.core.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.yumtaufikhidayat.tourismappcleanarchitecture.core.data.source.remote.response.TourismResponse

data class ListTourismResponse(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("places")
    val places: List<TourismResponse>
)