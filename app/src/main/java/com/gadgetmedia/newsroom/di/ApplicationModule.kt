package com.gadgetmedia.newsroom.di

import android.app.Application
import android.content.Context
import com.gadgetmedia.newsroom.BuildConfig
import com.gadgetmedia.newsroom.repository.api.ApiService
import com.gadgetmedia.newsroom.util.SchedulerProvider
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideSchedulerProvider() = SchedulerProvider(Schedulers.io(), AndroidSchedulers.mainThread())

        @JvmStatic
        @Provides
        fun provideGson(): Gson {
            return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        }

        @JvmStatic
        @Provides
        fun provideOkHttpClient(application: Application): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BASIC

            val cacheDir = File(application.cacheDir, UUID.randomUUID().toString())
            // 10 MiB cache
            val cache = Cache(cacheDir, 10 * 1024 * 1024)

            return OkHttpClient.Builder()
                    .cache(cache)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .build()

        }

        @JvmStatic
        @Provides
        fun provideApiService(gson: Gson, okHttpClient: OkHttpClient): ApiService {

            return Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build().create(ApiService::class.java)


        }

    }
}