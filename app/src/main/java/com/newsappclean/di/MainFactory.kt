package com.newsappclean.di

import com.newsappclean.domain.ArticleGateway
import com.newsappclean.ui.Presenter

class MainFactory(private val articleGateway: ArticleGateway):Factory<Presenter> {
    override fun create(): Presenter {
        return Presenter(articleGateway)
    }
}