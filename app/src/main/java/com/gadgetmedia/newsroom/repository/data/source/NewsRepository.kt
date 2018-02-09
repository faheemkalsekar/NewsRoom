package com.gadgetmedia.newsroom.repository.data.source

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Concrete implementation to load tasks from the data sources into a cache.
 * <p>
 * By marking the constructor with {@code @Inject} and the class with {@code @Singleton}, Dagger
 * injects the dependencies required to create an instance of the NewsRepository (if it fails, it
 * emits a compiler error). It uses {@link TasksRepositoryModule} to do so, and the constructed
 * instance is available in {@link AppComponent}.
 * <p />
 * Dagger generated code doesn't require public access to the constructor or class, and
 * therefore, to ensure the developer doesn't instantiate the class manually and bypasses Dagger,
 * it's good practice minimise the visibility of the class/constructor as much as possible.
 */
@Singleton
class NewsRepository @Inject constructor(@Remote private val newsRemoteDataSource: NewsDataSource,
                                         @Local private val newsLocalDataSource: NewsDataSource) : NewsDataSource {

    /**
     * By marking the constructor with {@code @Inject}, Dagger will try to inject the dependencies
     * required to create an instance of the NewsRepository. Because {@link NewsDataSource} is an
     * interface, we must provide to Dagger a way to build those arguments, this is done in
     * {@link NewsRepositoryModule}.
     * <P>
     * When two arguments or more have the same type, we must provide to Dagger a way to
     * differentiate them. This is done using a qualifier.
     * <p>
     * Dagger strictly enforces that arguments not marked with {@code @Nullable} are not injected
     * with {@code @Nullable} values.
     */

    override fun getNews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}