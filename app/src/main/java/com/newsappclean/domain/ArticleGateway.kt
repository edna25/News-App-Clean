package com.newsappclean.domain

interface ArticleGateway {
    suspend fun fetchArticles() : MutableList<ArticleData>
}