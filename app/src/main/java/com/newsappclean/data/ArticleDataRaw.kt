package com.newsappclean.data

import com.google.gson.annotations.SerializedName

data class ArticleDataRaw(
    @SerializedName("author")
    var author:String?,

    @SerializedName("title")
    var title: String?,

    @SerializedName("description")
    var description: String?,

    @SerializedName("url")
    var url:String?,

    @SerializedName("urlToImage")
    var urlToImage: String?,

    @SerializedName("publishedAt")
    var publishedAt: String?,

    @SerializedName("content")
    var content: String?
)
