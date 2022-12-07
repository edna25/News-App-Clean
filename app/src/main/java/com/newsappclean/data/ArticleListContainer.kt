package com.newsappclean.data

import com.google.gson.annotations.SerializedName

data class ArticleListContainer(
    @SerializedName("articles")
    val articleResult: MutableList<ArticleDataRaw>
)
