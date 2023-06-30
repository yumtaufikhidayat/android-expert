package com.yumtaufikhidayat.tourismappflow.di

import com.yumtaufikhidayat.tourismappflow.core.di.CoreComponent
import com.yumtaufikhidayat.tourismappflow.detail.DetailTourismActivity
import com.yumtaufikhidayat.tourismappflow.favorite.FavoriteFragment
import com.yumtaufikhidayat.tourismappflow.home.HomeFragment
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: DetailTourismActivity)
}