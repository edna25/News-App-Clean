package com.newsappclean.domain

interface ArticleGateway {
    fun fetchArticles() : List<ArticleData>
}