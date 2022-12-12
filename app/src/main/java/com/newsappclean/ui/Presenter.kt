package com.newsappclean.ui

import com.newsappclean.domain.ArticleData
import com.newsappclean.usecase.FetchArticlesUseCase
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class Presenter(private val fetchArticlesUseCase: FetchArticlesUseCase):MainContract.Presenter {

    private var view: MainContract.View? = null
    private var articles = mutableListOf<ArticleData>()

    private val scope = MainScope()

    override fun onViewReady(view : MainContract.View, query : String) {
        this.view = view
        scope.launch {
            try{
                articles = if(query.isEmpty()){
                    fetchArticlesUseCase.fetchArticles()
                }else{
                    fetchArticlesUseCase.fetchArticles(query)
                }
                if(articles.isNotEmpty()){
                    view.showArticles(articles)
                    view.hideLoading()
                }
            }catch(exception:Exception){
                view.showDialog(exception.toString())
                onViewDestroy()
            }
        }
    }

    override fun onViewDestroy() {
        view?.hideLoading()
        view = null
    }


}