package com.newsappclean.usecase

import com.newsappclean.domain.ArticleData
import com.newsappclean.domain.ArticleGateway

class FetchArticlesUseCase(private val repo: ArticleGateway) {
   suspend fun fetchArticles(): MutableList<ArticleData>
   {
       return repo.fetchArticles()
   }
    suspend fun fetchArticles(query:String):MutableList<ArticleData>{
        return repo.fetchArticles(query.trim())
    }
}