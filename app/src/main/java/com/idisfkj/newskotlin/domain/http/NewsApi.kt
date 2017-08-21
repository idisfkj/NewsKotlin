package com.idisfkj.newskotlin.domain.http

import com.idisfkj.newskotlin.NewsArticleListModel
import com.idisfkj.newskotlin.NewsSourcesListModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by idisfkj on 2017/8/15.
 * Email : idisfkj@gmail.com.
 */
interface NewsApi {

    @GET("articles")
    fun getArticles(@QueryMap options: MutableMap<String, Any?>): Observable<NewsArticleListModel?>

    @GET("sources")
    fun getSources(@QueryMap options: MutableMap<String, Any?>): Observable<NewsSourcesListModel?>
}