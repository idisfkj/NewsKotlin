package com.idisfkj.newskotlin.subscribe.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.idisfkj.newskotlin.NewsConfig
import com.idisfkj.newskotlin.NewsSourcesModel
import com.idisfkj.newskotlin.R
import com.idisfkj.newskotlin.extension.changeText
import com.idisfkj.newskotlin.extension.changeTextColor
import com.idisfkj.newskotlin.extension.displayImage
import kotlinx.android.synthetic.main.item_subscribe_content.view.*

/**
 * Created by idisfkj on 2017/8/18.
 * Email : idisfkj@gmail.com.
 */
class SubscribeContentAdapter(val list: List<NewsSourcesModel>, val itemClick: (String) -> Unit)
    : RecyclerView.Adapter<SubscribeContentAdapter.SubscribeContentVH>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SubscribeContentVH {
        return SubscribeContentVH(LayoutInflater.from(parent?.context).inflate(R.layout.item_subscribe_content, parent, false), itemClick)
    }

    override fun onBindViewHolder(holder: SubscribeContentVH?, position: Int) {
        holder?.bindData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class SubscribeContentVH(view: View, val itemClick: (String) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindData(newsSourcesModel: NewsSourcesModel) {
            with(newsSourcesModel) {
                itemView.imageView.displayImage(url = NewsConfig.SUBSCRIBE_IMAGE_URL[id], width = 80)
                itemView.name.text = name
                itemView.description.text = description
                changeStatus(NewsConfig.DEFAULT_CATEGORY.contains(id))
                itemView.subscribe.setOnClickListener {
                    itemClick(id)
                    changeStatus(NewsConfig.DEFAULT_CATEGORY.contains(id))
                }
            }
        }

        fun changeStatus(subscribe: Boolean) {
            itemView.subscribe.apply {
                if (subscribe) {
                    changeText(R.string.has_subscribe)
                    changeTextColor(R.color.news_999999)
                } else {
                    changeText(R.string.subscribe)
                    changeTextColor(R.color.colorPrimary)
                }
            }
        }
    }
}