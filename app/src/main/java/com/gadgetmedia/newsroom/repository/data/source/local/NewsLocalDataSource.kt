package com.gadgetmedia.newsroom.repository.data.source.local

import com.gadgetmedia.newsroom.repository.data.source.NewsDataSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Concrete implementation of a data source as a db.
 */
@Singleton
class NewsLocalDataSource @Inject constructor() : NewsDataSource {
    override fun getNews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}