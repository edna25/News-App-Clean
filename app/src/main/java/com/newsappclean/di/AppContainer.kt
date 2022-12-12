package com.newsappclean.di

import com.newsappclean.data.ArticlesRepository
import com.newsappclean.data.NewsRemoteService
import com.newsappclean.domain.ArticleGateway
import com.newsappclean.usecase.FetchArticlesUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer {
    private val newsRemoteService = retrofit.create(NewsRemoteService::class.java)
    private val articleGateway : ArticleGateway = ArticlesRepository(newsRemoteService)
    private val fetchArticlesUseCase : FetchArticlesUseCase = FetchArticlesUseCase(articleGateway)
    val mainFactory = MainFactory(fetchArticlesUseCase)

    companion object{
        private const val base = "https://newsapi.org/"
        private val retrofit = Retrofit.Builder()
            .baseUrl(base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}