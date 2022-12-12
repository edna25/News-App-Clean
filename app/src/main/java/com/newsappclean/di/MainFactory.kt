package com.newsappclean.di

import com.newsappclean.ui.Presenter
import com.newsappclean.usecase.FetchArticlesUseCase

class MainFactory(private val fetchArticlesUseCase: FetchArticlesUseCase):Factory<Presenter> {
    override fun create(): Presenter {
        return Presenter(fetchArticlesUseCase)
    }
}