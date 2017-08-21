package com.idisfkj.newskotlin.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.idisfkj.newskotlin.NewsConfig
import com.idisfkj.newskotlin.R
import com.idisfkj.newskotlin.domain.DelegatesExt
import com.idisfkj.newskotlin.main.adapter.MainFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity(), ToolBarManager {
    var category by DelegatesExt.getPreference(this, NewsConfig.CATEGORY, NewsConfig.DEFAULT_CATEGORY_STRING)

    override val toolBar by lazy { find<Toolbar>(R.id.toolBar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolBar()
        toolBarTitle = NewsConfig.DEFAULT_TITLE
        NewsConfig.DEFAULT_CATEGORY = category.split("#").toMutableList()
        tabLayout.setupWithViewPager(viewPager)
        viewPager.adapter = MainFragmentAdapter(supportFragmentManager)
    }

    override fun onResume() {
        super.onResume()
        if (NewsConfig.UPDATE_ADAPTER) {
            viewPager.adapter.notifyDataSetChanged()
            NewsConfig.UPDATE_ADAPTER = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        var categoryName: String = ""
        NewsConfig.DEFAULT_CATEGORY.forEachIndexed { index, s ->
            when (index) {
                NewsConfig.DEFAULT_CATEGORY.size - 1 -> categoryName += s
                else -> categoryName += s + "#"
            }
        }
        category = categoryName
    }
}

