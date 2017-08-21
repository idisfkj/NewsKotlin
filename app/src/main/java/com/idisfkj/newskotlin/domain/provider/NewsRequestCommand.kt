package com.idisfkj.newskotlin.domain.provider

import com.idisfkj.newskotlin.domain.http.DefaultDisposableObserver

/**
 * Created by idisfkj on 2017/8/20.
 * Email : idisfkj@gmail.com.
 */
class NewsRequestCommand<T>(private val params: MutableMap<String, Any?>, val tClass: Class<T>,
                            private val defaultDisposableObserver: DefaultDisposableObserver<T>,
                            private val provider: NewsProvider<T> = NewsProvider(defaultDisposableObserver)) : RequestCommand {
    override fun execute() {
        provider.request(params, tClass)
    }

    override fun cancelExecute() {
        provider.dispose()
    }
}