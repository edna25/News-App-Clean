package com.newsappclean.data

import com.newsappclean.domain.ArticleData

fun ArticleDataRaw.toDomain() = ArticleData(
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content,
)