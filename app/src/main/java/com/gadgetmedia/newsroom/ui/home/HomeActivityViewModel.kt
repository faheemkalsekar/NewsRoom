package com.gadgetmedia.newsroom.ui.home

import com.gadgetmedia.newsroom.repository.data.source.NewsRepository
import com.gadgetmedia.newsroom.util.SchedulerProvider

/**
 * Created by faheem on 6/2/18.
 */
class HomeActivityViewModel(private val repository: NewsRepository, private val schedulerProvider: SchedulerProvider) {

    fun getNews() = repository.getNews()
}