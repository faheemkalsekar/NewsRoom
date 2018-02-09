package com.gadgetmedia.newsroom.ui.home

import com.gadgetmedia.newsroom.di.FragmentScoped
import com.gadgetmedia.newsroom.repository.data.source.NewsRepository
import com.gadgetmedia.newsroom.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Enables inversion of control of the ViewModel and Navigator classes for Home Activity.
 */
@Module
abstract class HomeActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideViewModel(repository: NewsRepository, schedulerProvider: SchedulerProvider) = HomeActivityViewModel(repository, schedulerProvider)
    }

}