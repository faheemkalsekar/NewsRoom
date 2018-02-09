package com.gadgetmedia.newsroom.repository.data.source.remote

import com.gadgetmedia.newsroom.repository.data.source.NewsDataSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Implementation of the data source that fetches data from the server.
 */
@Singleton
class NewsRemoteDataSource @Inject constructor() : NewsDataSource {
    override fun getNews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}