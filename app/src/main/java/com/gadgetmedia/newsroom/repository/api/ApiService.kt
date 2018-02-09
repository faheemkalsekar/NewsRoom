package com.gadgetmedia.newsroom.repository.api

import com.gadgetmedia.newsroom.repository.data.News
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("?index={index}")
    fun getUsers(@Path("index") index: String): Observable<List<News>>

}