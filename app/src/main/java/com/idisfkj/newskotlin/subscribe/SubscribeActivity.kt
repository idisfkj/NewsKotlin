package com.idisfkj.newskotlin.subscribe

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.idisfkj.newskotlin.NewsConfig
import com.idisfkj.newskotlin.NewsSourcesListModel
import com.idisfkj.newskotlin.NewsSourcesModel
import com.idisfkj.newskotlin.R
import com.idisfkj.newskotlin.domain.http.DefaultDisposableObserver
import com.idisfkj.newskotlin.domain.provider.NewsRequestCommand
import com.idisfkj.newskotlin.domain.provider.RequestCommand
import com.idisfkj.newskotlin.main.ToolBarManager
import com.idisfkj.newskotlin.subscribe.adapter.SubscribeCategoryAdapter
import com.idisfkj.newskotlin.subscribe.adapter.SubscribeContentAdapter
import kotlinx.android.synthetic.main.activity_subscribe.*
import org.jetbrains.anko.find

class SubscribeActivity : AppCompatActivity(), ToolBarManager {
    override val toolBar by lazy { find<Toolbar>(R.id.toolBar) }
    var requestCommand: RequestCommand? = null
    var categoryList = mutableListOf<String>()
    var contentList = mutableListOf<NewsSourcesModel>()
    var contentMap = mutableMapOf<String, MutableList<NewsSourcesModel>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscribe)
        setupRecyclerView()
        toolBarTitle = "Subscribe"
        enableHomeAsUp { onBackPressed() }
    }

    fun setupRecyclerView() {
        categoryRecycler.clipToPadding = false
        contentRecycler.clipToPadding = false
        categoryRecycler.layoutManager = LinearLayoutManager(this)
        contentRecycler.layoutManager = LinearLayoutManager(this)
        contentRecycler.adapter = SubscribeContentAdapter(contentList) {
            if (!NewsConfig.DEFAULT_CATEGORY.contains(it)) NewsConfig.DEFAULT_CATEGORY.add(it)
            else NewsConfig.DEFAULT_CATEGORY.remove(it)
            NewsConfig.UPDATE_ADAPTER = true
        }
        categoryRecycler.adapter = SubscribeCategoryAdapter(categoryList) {
            categoryList[categoryList.size - 1] = categoryList.indexOf(it).toString()
            categoryRecycler.adapter.notifyDataSetChanged()
            contentList.clear()
            contentMap[it]?.let { value -> contentList.addAll(value) }
            contentRecycler.adapter.notifyDataSetChanged()
        }
    }

    override fun onStart() {
        super.onStart()
        if (categoryList.isEmpty()) setupRequest()
    }

    fun setupRequest() {
        val params = mutableMapOf<String, Any?>(
                "language" to "en"
        )
        requestCommand = NewsRequestCommand(params, NewsSourcesListModel::class.java,
                object : DefaultDisposableObserver<NewsSourcesListModel>() {
                    override fun onNext(t: NewsSourcesListModel) {
                        categoryList.clear()
                        contentList.clear()
                        contentMap.clear()
                        t.sources.forEach {
                            if (!categoryList.contains(it.category)) {
                                categoryList.add(it.category)
                                contentMap.put(it.category, mutableListOf())
                            }
                            contentMap[it.category]?.add(it)
                        }
                        categoryList.add("0")
                        contentMap[categoryList[0]]?.let { value -> contentList.addAll(value) }
                        categoryRecycler.adapter.notifyDataSetChanged()
                        contentRecycler.adapter.notifyDataSetChanged()
                    }
                })
        requestCommand?.execute()
    }

    override fun onDestroy() {
        super.onDestroy()
        requestCommand?.cancelExecute()
    }

}
