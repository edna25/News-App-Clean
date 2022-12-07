package com.newsappclean.data

import com.newsappclean.domain.ArticleData
import com.newsappclean.domain.ArticleGateway
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArticlesRepository(private val remoteService: NewsRemoteService): ArticleGateway
{
    private val apiKey = "98262df4f3a14d19a3b6cc84be8c004e"

    override suspend fun fetchArticles(): MutableList<ArticleData>{
        return withContext(Dispatchers.IO){
            val result = remoteService.getsArticles(apiKey, "ph").articleResult.map { it.toDomain() }
            result
        }.toMutableList()

    }

}