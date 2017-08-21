package com.idisfkj.newskotlin.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.idisfkj.newskotlin.NewsConfig
import com.idisfkj.newskotlin.R
import com.idisfkj.newskotlin.main.adapter.MainFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity(), ToolBarManager {
    override val toolBar by lazy { find<Toolbar>(R.id.toolBar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolBar()
        toolBarTitle = NewsConfig.DEFAULT_TITLE
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
}

