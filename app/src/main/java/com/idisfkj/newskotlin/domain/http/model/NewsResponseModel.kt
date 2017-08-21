package com.idisfkj.newskotlin.domain.http.model

/**
 * Created by idisfkj on 2017/8/15.
 * Email : idisfkj@gmail.com.
 */
data class NewsResponseArticleModel(val status: String, val source: String, val sortBy: String)

data class NewsResponseSourceModel(val status: String)