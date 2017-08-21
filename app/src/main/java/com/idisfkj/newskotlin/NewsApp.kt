package com.idisfkj.newskotlin

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.idisfkj.newskotlin.domain.DelegatesExt

/**
 * Created by idisfkj on 2017/8/16.
 * Email : idisfkj@gmail.com.
 */
class NewsApp : Application() {
    companion object {
        var instance: NewsApp by DelegatesExt.notNullSingleValue<NewsApp>()
    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        instance = this
    }
}