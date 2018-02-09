package com.gadgetmedia.newsroom.repository.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "news")
data class News(
        @PrimaryKey
        @ColumnInfo(name = "entryid")
        val entryid: String,
        @ColumnInfo(name = "headline")
        val headline: String,
        @ColumnInfo(name = "image")
        val image: String,
        @ColumnInfo(name = "body")
        val body: String,
        @ColumnInfo(name = "isRead")
        val isRead: Boolean
)
