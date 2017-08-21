package com.idisfkj.newskotlin.category.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.idisfkj.newskotlin.NewsArticleModel
import com.idisfkj.newskotlin.R
import com.idisfkj.newskotlin.extension.displayImage
import kotlinx.android.synthetic.main.item_news.view.*

/**
 * Created by idisfkj on 2017/8/16.
 * Email : idisfkj@gmail.com.
 */
class CategoryAdapter(val list: MutableList<NewsArticleModel>, val itemClick: (NewsArticleModel) -> Unit)
    : RecyclerView.Adapter<CategoryAdapter.NewsViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false), itemClick)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    class NewsViewHolder(view: View, val itemClick: (NewsArticleModel) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindData(data: NewsArticleModel) {
            with(data) {
                itemView.image.displayImage(url = urlToImage)
                itemView.title.text = title
                itemView.author.text = author
                itemView.publishedAt.text = publishedAt?.substring(0, 10)
                itemView.setOnClickListener { itemClick(data) }
            }
        }
    }

}