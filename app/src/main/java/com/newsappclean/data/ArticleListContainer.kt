package com.newsappclean.data

import com.google.gson.annotations.SerializedName

data class ArticleListContainer(
    @SerializedName("articles")
    var articleList: List<ArticleDataRaw>
)
