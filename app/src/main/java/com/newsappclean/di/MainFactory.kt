package com.newsappclean.di

import com.newsappclean.domain.usecase.FetchArticlesUseCase
import com.newsappclean.ui.Presenter

class MainFactory(private val fetchArticlesUseCase: FetchArticlesUseCase) {
    fun create(): Presenter {
        return Presenter(fetchArticlesUseCase)
    }
}