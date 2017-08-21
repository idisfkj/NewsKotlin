package com.idisfkj.newskotlin.category

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.idisfkj.newskotlin.NewsArticleListModel
import com.idisfkj.newskotlin.NewsArticleModel
import com.idisfkj.newskotlin.NewsConfig
import com.idisfkj.newskotlin.R
import com.idisfkj.newskotlin.category.adapter.CategoryAdapter
import com.idisfkj.newskotlin.detail.NewsDetailActivity
import com.idisfkj.newskotlin.domain.http.DefaultDisposableObserver
import com.idisfkj.newskotlin.domain.provider.NewsRequestCommand
import com.idisfkj.newskotlin.domain.provider.RequestCommand
import kotlinx.android.synthetic.main.fragment_category.*
import org.jetbrains.anko.bundleOf
import org.jetbrains.anko.startActivity

/**
 * Created by idisfkj on 2017/8/16.
 * Email : idisfkj@gmail.com.
 */
class NewsCategoryFragment : Fragment() {

    var id: String? = null
    var dataList = mutableListOf<NewsArticleModel>()
    var requestCommand: RequestCommand? = null

    companion object {
        val CATEGORY_ID = "category_id"

        fun newInstance(id: String): NewsCategoryFragment {
            val instance = NewsCategoryFragment()
            instance.arguments = bundleOf(CATEGORY_ID to id)
            return instance
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_category, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        id = arguments[CATEGORY_ID] as String?
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.clipToPadding = false
        recyclerView.adapter = CategoryAdapter(dataList) {
            context.startActivity<NewsDetailActivity>(
                    NewsDetailActivity.WEB_URL to it.url,
                    NewsDetailActivity.TITLE to it.title)
        }
        swipeRefreshLayout.setOnRefreshListener {
            setupRequest(true)
        }
    }

    override fun onStart() {
        super.onStart()
        if (dataList.isEmpty()) setupRequest(false)
    }

    fun setupRequest(refresh: Boolean) {
        val params = mutableMapOf<String, Any?>(
                NewsConfig.REQUEST_SOURCE to id,
                NewsConfig.REQUEST_SORT_BY to NewsConfig.SortBy.TOP.sort
        )
        requestCommand = NewsRequestCommand(params, NewsArticleListModel::class.java,
                object : DefaultDisposableObserver<NewsArticleListModel>() {
                    override fun onNext(t: NewsArticleListModel) {
                        if (refresh) swipeRefreshLayout.isRefreshing = false
                        dataList.clear()
                        dataList.addAll(t.articles)
                        recyclerView.adapter.notifyDataSetChanged()
                    }

                    override fun onError(e: Throwable) {
                        super.onError(e)
                        if (refresh) swipeRefreshLayout.isRefreshing = false
                    }
                })
        requestCommand?.execute()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        requestCommand?.cancelExecute()
    }

}