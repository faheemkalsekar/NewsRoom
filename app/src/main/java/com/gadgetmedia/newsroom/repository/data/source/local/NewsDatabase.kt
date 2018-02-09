package com.gadgetmedia.newsroom.repository.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.gadgetmedia.newsroom.repository.data.News

@Database(entities = arrayOf(News::class), version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}
