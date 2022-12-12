package com.newsappclean.data

import com.newsappclean.domain.ArticleData
import com.newsappclean.domain.ArticleGateway
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArticlesRepository(private val remoteService: NewsRemoteService): ArticleGateway
{
    private val apiKey = "98262df4f3a14d19a3b6cc84be8c004e"
    private val country = "ph"

    override suspend fun fetchArticles(): MutableList<ArticleData>{
        return withContext(Dispatchers.IO){
            val result = remoteService.getsArticles(apiKey, country).articleResult.map { it.toDetails() }
            result
        }.toMutableList()

    }

    override suspend fun fetchArticles(query: String): MutableList<ArticleData> {
        return withContext(Dispatchers.IO){
            remoteService.getArticlesEverything(apiKey, query).articleResult.map { it.toDetails() }
        }.toMutableList()
    }

}