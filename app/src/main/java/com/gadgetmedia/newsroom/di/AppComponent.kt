package com.gadgetmedia.newsroom.di

import android.app.Application
import com.gadgetmedia.newsroom.NewsRoomApplication
import com.gadgetmedia.newsroom.repository.data.source.NewsRepository
import com.gadgetmedia.newsroom.source.NewsRepositoryModule
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
@Component(modules = arrayOf(NewsRepositoryModule::class, AndroidInjectionModule::class, ApplicationModule::class, ActivityBindingModule::class))
interface AppComponent : AndroidInjector<NewsRoomApplication> {

    fun getNewsRepository(): NewsRepository

    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

}