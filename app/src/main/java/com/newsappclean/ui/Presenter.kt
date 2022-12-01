package com.newsappclean.ui

import com.newsappclean.domain.ArticleGateway

class Presenter(private val repo:ArticleGateway):MainContract.Presenter {

    private var view: MainContract.View? = null


    override fun onViewReady(v: MainContract.View) {
        this.view = v
        if(view != null){
            val articles = repo.fetchArticles()
            if(articles.isEmpty()){
                view?.showLoading()
            }else{
                view?.showArticles(articles)
                view?.hideLoading()
            }
        }

    }

    override fun onViewDestroy() {
        view = null
    }


}