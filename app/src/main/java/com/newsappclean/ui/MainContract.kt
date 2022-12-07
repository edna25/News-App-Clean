package com.newsappclean.ui

import com.newsappclean.domain.ArticleData

interface MainContract {
    interface View
    {
        fun showLoading()
        fun hideLoading()
        fun showArticles(articleList: MutableList<ArticleData>)
        fun showDialog(msg : String)
    }
    interface Presenter
    {
        fun onViewReady(view : View, query : String)
        fun onViewDestroy()
//        fun onItemClicked(position:Int)
    }
    interface ItemClicked
    {
        fun onClicked(view: android.view.View, position: Int)
    }
}