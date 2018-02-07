package com.gadgetmedia.newsroom.di

import android.app.Application
import com.gadgetmedia.newsroom.NewsRoomApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * This is a Dagger component. Refer to {@link NewsRoomApplication} for the list of Dagger components
 * used in this application.
 * <p>
 * Even though Dagger allows annotating a {@link Component} as a singleton, the code
 * itself must ensure only one instance of the class is created. This is done in {@link
 * NewsRoomApplication}.
 * //{@link AndroidSupportInjectionModule}
 * // is the module from Dagger.Android that helps with the generation
 * // and location of subcomponents.
 */
@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, ApplicationModule::class, ActivityBindingModule::class))
interface AppComponent : AndroidInjector<NewsRoomApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

}