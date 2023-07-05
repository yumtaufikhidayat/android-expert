package com.yumtaufikhidayat.maps

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object MapsModule {
    val mapsModule = module {
        viewModel { MapsViewModel(get()) }
    }
}