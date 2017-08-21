package com.idisfkj.newskotlin

/**
 * Created by idisfkj on 2017/8/15.
 * Email : idisfkj@gmail.com.
 */
data class NewsArticleModel(val author: String, val title: String, val description: String, val url: String, val urlToImage: String, val publishedAt: String?)

data class NewsArticleListModel(val status: String, val source: String, val sortBy: String, val articles: MutableList<NewsArticleModel>)

data class NewsSourcesListModel(val status: String, val sources: MutableList<NewsSourcesModel>)

data class NewsSourcesModel(val id: String, val name: String, val description: String, val url: String
                            , val category: String, val language: String, val country: String, val urlsToLogos: UrlsToLogos, val sortBysAvailable: MutableList<String>)

data class UrlsToLogos(val small: String, val medium: String, val large: String)
