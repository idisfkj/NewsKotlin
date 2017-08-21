package com.idisfkj.newskotlin.domain.http

import com.idisfkj.newskotlin.NewsApp
import com.idisfkj.newskotlin.R
import io.reactivex.observers.DisposableObserver
import org.jetbrains.anko.longToast

/**
 * Created by idisfkj on 2017/8/16.
 * Email : idisfkj@gmail.com.
 */
open class DefaultDisposableObserver<T> : DisposableObserver<T>() {

    val NETWORK_ERROR: String = NewsApp.instance.applicationContext.getString(R.string.network_error)

    override fun onNext(t: T) {

    }

    override fun onError(e: Throwable) {
        NewsApp.instance.longToast(NETWORK_ERROR)
        e.printStackTrace()
    }

    override fun onComplete() {

    }
}