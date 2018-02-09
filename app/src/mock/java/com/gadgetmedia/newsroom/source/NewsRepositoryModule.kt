package com.gadgetmedia.newsroom.source

import android.app.Application
import android.arch.persistence.room.Room
import com.gadgetmedia.newsroom.FakeNewsRemoteDataSource
import com.gadgetmedia.newsroom.repository.data.source.Local
import com.gadgetmedia.newsroom.repository.data.source.NewsDataSource
import com.gadgetmedia.newsroom.repository.data.source.Remote
import com.gadgetmedia.newsroom.repository.data.source.local.NewsDao
import com.gadgetmedia.newsroom.repository.data.source.local.NewsDatabase
import com.gadgetmedia.newsroom.repository.data.source.local.NewsLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * This is used by Dagger to inject the required arguments into the {@link NewsRepository}.
 */
@Module
abstract class NewsRepositoryModule {
    @Singleton
    @Binds
    @Local
    internal abstract fun provideTasksLocalDataSource(dataSource: NewsLocalDataSource): NewsDataSource

    @Singleton
    @Binds
    @Remote
    internal abstract fun provideTasksRemoteDataSource(dataSource: FakeNewsRemoteDataSource): NewsDataSource

    @Module
    companion object {

        @JvmStatic
        @Singleton
        @Provides
        internal fun provideDb(context: Application): NewsDatabase {
            return Room.databaseBuilder(context.applicationContext, NewsDatabase::class.java, "News.db")
                    .build()
        }

        @JvmStatic
        @Singleton
        @Provides
        internal fun provideTasksDao(db: NewsDatabase): NewsDao {
            return db.newsDao()
        }
    }
}