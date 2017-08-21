package com.idisfkj.newskotlin.domain.provider

/**
 * Created by idisfkj on 2017/8/20.
 * Email : idisfkj@gmail.com.
 */
interface Provider<T> {
    fun request(params: MutableMap<String, Any?>, tClass: Class<T>)

    fun dispose()
}