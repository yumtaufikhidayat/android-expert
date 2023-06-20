package com.yumtaufikhidayat.reactivexsearch.model

import com.google.gson.annotations.SerializedName

data class PlacesItem(
    @field:SerializedName("place_name")
    val placeName: String
)
