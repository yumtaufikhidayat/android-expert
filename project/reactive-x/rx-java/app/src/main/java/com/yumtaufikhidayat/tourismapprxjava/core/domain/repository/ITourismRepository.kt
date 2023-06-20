package com.yumtaufikhidayat.tourismapprxjava.core.domain.repository

import com.yumtaufikhidayat.tourismapprxjava.core.data.Resource
import com.yumtaufikhidayat.tourismapprxjava.core.domain.model.Tourism
import io.reactivex.Flowable

interface ITourismRepository {
    fun getAllTourism(): Flowable<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flowable<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}