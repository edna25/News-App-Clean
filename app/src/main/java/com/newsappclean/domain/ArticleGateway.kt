package com.newsappclean.domain

interface ArticleGateway {
    suspend fun fetchArticles() : MutableList<ArticleData>
    suspend fun fetchArticles(query:String) : MutableList<ArticleData>
}