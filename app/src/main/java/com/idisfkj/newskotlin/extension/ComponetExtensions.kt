package com.idisfkj.newskotlin.extension

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.widget.TextView
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.controller.BaseControllerListener
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.common.ResizeOptions
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.idisfkj.newskotlin.NewsApp
import com.idisfkj.newskotlin.R
import io.reactivex.disposables.Disposable

/**
 * Created by idisfkj on 2017/8/16.
 * Email : idisfkj@gmail.com.
 */
inline fun <reified T> Context.startActivity(vararg pair: Pair<String, Any>) {
    val intent = Intent(this, T::class.java)
    for ((key, value) in pair) {
        when (value) {
            is String -> intent.putExtra(key, value)
            is Int -> intent.putExtra(key, value)
            is Float -> intent.putExtra(key, value)
            is Double -> intent.putExtra(key, value)
        }
    }
    startActivity(intent)
}

fun Disposable.executeDispose() {
    if (!this.isDisposed) {
        dispose()
    }
}

fun SimpleDraweeView.displayImage(url: String?, width: Int = 200, listener: BaseControllerListener<Any>? = null) {
    if (url == null) return
    this.hierarchy.setPlaceholderImage(R.drawable.news_default_bg)
    val imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
            .setResizeOptions(ResizeOptions(width, width))
            .build()
    val controller = Fresco.newDraweeControllerBuilder()
            .setImageRequest(imageRequest)
            .setAutoPlayAnimations(true)
            .setControllerListener(listener)
            .setOldController(this.controller)
            .build()
    this.controller = controller
}

inline fun <T> T.condition(condition: (T) -> Boolean, block: () -> T): T = if (condition(this)) block() else this

inline fun <T> T.conditionNull(block: () -> T): T = if (this == null) block() else this

fun TextView.changeTextColor(@ColorRes id: Int) {
    setTextColor(ContextCompat.getColor(NewsApp.instance.baseContext, id))
}

fun TextView.changeText(@StringRes id: Int) {
    text = NewsApp.instance.getString(id)
}

