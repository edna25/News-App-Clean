package com.newsappclean.ui

import com.newsappclean.domain.ArticleData
import com.newsappclean.domain.ArticleGateway
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class Presenter(private val repo:ArticleGateway):MainContract.Presenter {

    private var view: MainContract.View? = null
    private var articles = mutableListOf<ArticleData>()

    private val scope = MainScope()

    override fun onViewReady(view : MainContract.View, query : String) {
        this.view = view
        scope.launch {
            try{
                articles = if(query.isEmpty()){
                    repo.fetchArticles()
                }else{
                    repo.fetchArticles(query)
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
        view = null
    }


}