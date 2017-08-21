package com.idisfkj.newskotlin.main

import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.Toolbar
import com.idisfkj.newskotlin.R
import com.idisfkj.newskotlin.subscribe.SubscribeActivity
import org.jetbrains.anko.startActivity

/**
 * Created by idisfkj on 2017/8/17.
 * Email : idisfkj@gmail.com.
 */
interface ToolBarManager {
    val toolBar: Toolbar
    var toolBarTitle: String
        set(value) {
            toolBar.title = value
        }
        get() = toolBar.title.toString()

    fun initToolBar() {
        toolBar.inflateMenu(R.menu.menu)
        toolBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.subscribe -> toolBar.context.startActivity<SubscribeActivity>()
            }
            true
        }
    }

    fun enableHomeAsUp(back: () -> Unit) {
        toolBar.navigationIcon = DrawerArrowDrawable(toolBar.context)
        toolBar.setNavigationOnClickListener { back() }
    }

}