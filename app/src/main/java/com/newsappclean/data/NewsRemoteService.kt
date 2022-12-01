package com.newsappclean.data

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsRemoteService {
    @GET("v2/top-headlines")
    fun getsArticles(@Query("apiKey")key : String, @Query("country") country: String):ArticleListContainer
}