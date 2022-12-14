package com.newsappclean.ui

import com.newsappclean.domain.ArticleData
import com.newsappclean.domain.usecase.FetchArticlesUseCase
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class Presenter(private val fetchArticlesUseCase: FetchArticlesUseCase):MainContract.Presenter {

    private var view: MainContract.View? = null
    private var articles = mutableListOf<ArticleData>()
    private val scope = MainScope()

    override fun onViewReady(view : MainContract.View) {
        this.view = view
        view.showLoading()
        fetchArticles("")
    }

    override fun onViewDestroy() {
        view?.hideLoading()
        view = null
    }

    override fun searchArticles(query: String) {
        fetchArticles(query)
    }

    private fun fetchArticles(query : String){
        scope.launch {
            try{
                articles = if(query.isEmpty()){
                    fetchArticlesUseCase.fetchArticles()
                }else{
                    fetchArticlesUseCase.fetchArticles(query)
                }
                if(articles.isNotEmpty()){
                    view?.showArticles(articles)
                    view?.hideLoading()
                }else{
                    view?.showDialog("No result found.")
                }
            }catch(exception:Exception){
                view?.showDialog("Connection Interrupted: " + exception.message.toString())
                onViewDestroy()
            }
        }
    }
}