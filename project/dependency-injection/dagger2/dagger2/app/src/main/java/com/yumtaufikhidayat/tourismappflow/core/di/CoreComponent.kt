package com.yumtaufikhidayat.tourismappflow.core.di

import android.content.Context
import com.yumtaufikhidayat.tourismappflow.core.domain.repository.ITourismRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideRepository() : ITourismRepository
}