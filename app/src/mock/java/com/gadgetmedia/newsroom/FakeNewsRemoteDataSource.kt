package com.gadgetmedia.newsroom

import com.gadgetmedia.newsroom.repository.data.source.NewsDataSource
import javax.inject.Inject

/**
 * Implementation of a remote data source with static access to the data for easy testing.
 */
class FakeNewsRemoteDataSource @Inject constructor() : NewsDataSource {

    override fun getNews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
