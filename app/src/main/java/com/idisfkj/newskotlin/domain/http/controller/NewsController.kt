package com.idisfkj.newskotlin.domain.http.controller

import android.util.Log
import com.google.gson.Gson
import com.idisfkj.newskotlin.NewsArticleListModel
import com.idisfkj.newskotlin.NewsConfig
import com.idisfkj.newskotlin.NewsSourcesListModel
import com.idisfkj.newskotlin.domain.http.NewsApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

/**
 * Created by idisfkj on 2017/8/15.
 * Email : idisfkj@gmail.com.
 */
class NewsController {

    companion object {
        val instance by lazy { NewsController() }
    }

    private var mNewsApi: NewsApi? = null
    private var mGson: Gson? = null

    fun getNewsApi(): NewsApi {
        if (mNewsApi == null) {
            val retrofit = Retrofit.Builder()
                    .baseUrl(NewsConfig.API_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)).build())
                    .build()
            mNewsApi = retrofit.create(NewsApi::class.java)
        }
        return mNewsApi!!
    }

    fun <T> doGet(params: MutableMap<String, Any?>, tClass: Class<T>): Observable<T?> {
        return initParams(params, tClass)!!.observeOn(Schedulers.io()).flatMap { tempString ->
            if (tClass == NewsArticleListModel::class.java) {
                getNewsApi().getArticles(tempString).subscribeOn(Schedulers.io())
            } else {
                getNewsApi().getSources(tempString).subscribeOn(Schedulers.io())
            }
        }.flatMap { newsResponse ->
            if (newsResponse is NewsArticleListModel && newsResponse.status.equals("ok")
                    || (newsResponse is NewsSourcesListModel && newsResponse.status.equals("ok"))) {
                val json = getGson()?.toJson(newsResponse!!)
                if (json.isNullOrEmpty()) return@flatMap null!!
                val data = getGson()?.fromJson(json, tClass)
                Observable.just(data)
            } else {
                Observable.error<T> { Exception() }
            }
        }.observeOn(AndroidSchedulers.mainThread())
                .doOnError { t -> Log.d("TAG", "throwable: " + t) }
    }

    fun <T> initParams(params: MutableMap<String, Any?>, tClass: Class<T>): Observable<MutableMap<String, Any?>>? {
        if (tClass == NewsArticleListModel::class.java) {
            params.put(NewsConfig.API_KEY, NewsConfig.API_KEY_VALUE)
        }
        return Observable.just(params)
    }

    fun getGson(): Gson? {
        mGson = if (mGson == null) Gson() else mGson
        return mGson
    }
}