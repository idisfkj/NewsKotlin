package com.idisfkj.newskotlin.domain.provider

import com.idisfkj.newskotlin.domain.http.DefaultDisposableObserver
import com.idisfkj.newskotlin.domain.http.controller.NewsController
import com.idisfkj.newskotlin.extension.executeDispose
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by idisfkj on 2017/8/20.
 * Email : idisfkj@gmail.com.
 */
class NewsProvider<T>(private val defaultDisposableObserver: DefaultDisposableObserver<T>) : Provider<T> {

    private var requestDispose: Disposable? = null

    override fun request(params: MutableMap<String, Any?>, tClass: Class<T>) {
        requestDispose = NewsController.instance.doGet(params, tClass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(defaultDisposableObserver)
    }

    override fun dispose() {
        requestDispose?.executeDispose()
    }
}