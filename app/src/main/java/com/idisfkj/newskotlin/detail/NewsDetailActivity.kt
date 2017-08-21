package com.idisfkj.newskotlin.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.webkit.WebView
import android.webkit.WebViewClient
import com.idisfkj.newskotlin.R
import com.idisfkj.newskotlin.main.ToolBarManager
import kotlinx.android.synthetic.main.activity_news_detail.*
import org.jetbrains.anko.find

class NewsDetailActivity : AppCompatActivity(), ToolBarManager {
    override val toolBar by lazy { find<Toolbar>(R.id.toolBar) }

    companion object {
        val WEB_URL = "web_url"
        val TITLE = "title"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        toolBarTitle = intent.extras.getString(TITLE)
        setupWebView()
        webView.loadUrl(intent.getStringExtra(WEB_URL))
        enableHomeAsUp { onBackPressed() }
    }

    fun setupWebView() {
        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                return super.shouldOverrideUrlLoading(view, url)
            }
        })
    }
}
