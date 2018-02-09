package com.gadgetmedia.newsroom

import com.gadgetmedia.newsroom.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class NewsRoomApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

}