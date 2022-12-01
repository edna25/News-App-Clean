package com.newsappclean.data

import com.newsappclean.domain.ArticleData
import com.newsappclean.domain.ArticleGateway

class ArticlesRepository(val remoteService: NewsRemoteService): ArticleGateway
{
    val apiKey = "98262df4f3a14d19a3b6cc84be8c004e"

//    private val articles = listOf(ArticleData("a", "b", "c",
//        "https://www.washingtonpost.com/information/2022/01/01/editors-note/", "e",
//        "2022-11-30T22:28:47Z", "g"))
    override fun fetchArticles(): List<ArticleData> {
        return remoteService.getsArticles(apiKey, "ph").articleList.map { it.toDomain() }
        //return articles
    }

}