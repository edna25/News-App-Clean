package com.newsappclean.ui

import com.newsappclean.domain.ArticleGateway
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class Presenter(private val repo:ArticleGateway):MainContract.Presenter {

    private var view: MainContract.View? = null

    private val scope = MainScope()

    override fun onViewReady(v: MainContract.View) {
        this.view = v
        scope.launch {
            try{
                val articles = repo.fetchArticles()
                if(articles.isNotEmpty()){
                    view?.showArticles(articles)
                    view?.hideLoading()
                }
            }catch(exception:Exception){
                view?.showDialog(exception.toString())
                view = null
            }
        }
    }

    override fun onViewDestroy() {
        view = null
    }


}