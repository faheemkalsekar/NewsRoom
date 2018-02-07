package com.gadgetmedia.newsroom

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber


class NewsRoomApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()

    }

    override fun onCreate() {
        super.onCreate()
        Timber.uprootAll()
        Timber.plant(Timber.DebugTree())


    }

}