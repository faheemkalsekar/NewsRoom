package com.gadgetmedia.newsroom.ui.home

import com.gadgetmedia.newsroom.repository.data.source.NewsRepository
import com.gadgetmedia.newsroom.util.SchedulerProvider
import dagger.Module
import dagger.Provides

/**
 * Enables inversion of control of the ViewModel and Navigator classes for Home Activity.
 */
@Module
class HomeActivityModule {

    @Provides
    fun provideViewModel(repository: NewsRepository, schedulerProvider: SchedulerProvider) = HomeActivityViewModel(repository, schedulerProvider)


}