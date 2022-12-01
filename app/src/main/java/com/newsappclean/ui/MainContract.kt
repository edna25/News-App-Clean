package com.newsappclean.ui

import com.newsappclean.domain.ArticleData

interface MainContract {
    interface View
    {
        fun showLoading()
        fun hideLoading()
        fun showArticles(articleList: List<ArticleData>)
    }
    interface Presenter
    {
        fun onViewReady(v : View)
        fun onViewDestroy()
//        fun onItemClicked(position:Int)
    }
    interface ItemClicked
    {
        fun onClicked(view: android.view.View, position: Int)
    }
}