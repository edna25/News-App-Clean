package com.newsappclean.data

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsRemoteService {
    @GET("v2/top-headlines")
    suspend fun getArticles(@Query("apiKey")key : String, @Query("country") country: String): ArticleListContainer

    @GET("v2/everything")
    suspend fun searchArticles(@Query("apiKey")key : String, @Query("q") query:String):ArticleListContainer
}