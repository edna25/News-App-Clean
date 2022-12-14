package com.newsappclean.domain.usecase

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

//open class ArticleRepository {
//    fun fetchArticles() : List<String>{
//        return listOf("Covid", "Tech")
//    }
//}
//
//class ArticleRepositoryV3 : ArticlesRepository {
//    override suspend fun fetchArticles(): MutableList<ArticleData> {
//        return super.fetchArticles().map { "" }
//    }
//}
//
//class ArticleRepositoryV2(val repo : ArticleRepository) {
//    fun fetchArticles() : List<String> {
//        val original = repo.fetchArticles()
//        return original.map { "$it-" }
//    }
//}