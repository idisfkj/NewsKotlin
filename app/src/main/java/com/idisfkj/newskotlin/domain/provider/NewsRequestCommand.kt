package com.idisfkj.newskotlin.domain.provider

import io.reactivex.observers.DisposableObserver

/**
 * Created by idisfkj on 2017/8/20.
 * Email : idisfkj@gmail.com.
 */
class NewsRequestCommand<T>(private val params: MutableMap<String, Any?>, val tClass: Class<T>,
                            private val defaultDisposableObserver: DisposableObserver<T>,
                            private val provider: Provider<T> = NewsProvider(defaultDisposableObserver)) : RequestCommand {
    override fun execute() {
        provider.request(params, tClass)
    }

    override fun cancelExecute() {
        provider.dispose()
    }
}