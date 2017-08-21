package com.idisfkj.newskotlin.domain

import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by idisfkj on 2017/8/15.
 * Email : idisfkj@gmail.com.
 */
object DelegatesExt {
    fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
    fun <T> getPreference(context: Context, name: String, default: T): ReadWriteProperty<Any?, T> = Preference(context, name, default)
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

class Preference<T>(val context: Context, val name: String, val default: T) : ReadWriteProperty<Any?, T> {

    val ref: SharedPreferences by lazy { context.getSharedPreferences("News", Context.MODE_PRIVATE) }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreferenceByName(name, default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name, value)
    }

    private fun findPreferenceByName(name: String, default: T): T = with(ref) {
        val res: Any = when (default) {
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is String -> getString(name, default)
            is Long -> getLong(name, default)
            is Float -> getFloat(name, default)
            else -> throw IllegalArgumentException("this type not support")
        }
        return res as T
    }

    private fun putPreference(name: String, value: T) = with(ref.edit()) {
        when (value) {
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is String -> putString(name, value)
            is Long -> putLong(name, value)
            is Float -> putFloat(name, value)
            else -> throw IllegalArgumentException("this type not support")
        }.apply()
    }

}

