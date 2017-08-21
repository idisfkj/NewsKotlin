package com.idisfkj.newskotlin.domain

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by idisfkj on 2017/8/15.
 * Email : idisfkj@gmail.com.
 */
object DelegatesExt {
    fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
}

class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {

    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value else throw IllegalStateException("${property.name} not initialized")
    }
}

