package com.idisfkj.newskotlin.subscribe.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.idisfkj.newskotlin.R
import com.idisfkj.newskotlin.extension.changeTextColor
import kotlinx.android.synthetic.main.item_subscribe_category.view.*

/**
 * Created by idisfkj on 2017/8/18.
 * Email : idisfkj@gmail.com.
 */
class SubscribeCategoryAdapter(val list: MutableList<String>, val itemClick: (String) -> Unit) : RecyclerView.Adapter<SubscribeCategoryAdapter.SubscribeCategoryVH>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SubscribeCategoryVH {
        return SubscribeCategoryVH(LayoutInflater.from(parent?.context).inflate(R.layout.item_subscribe_category, parent, false), itemClick)
    }

    override fun onBindViewHolder(holder: SubscribeCategoryVH?, position: Int) {
        holder?.bindData(list[position], position == list[list.size - 1].toInt())
    }

    override fun getItemCount(): Int {
        return list.size - 1
    }

    class SubscribeCategoryVH(view: View, val itemClick: (String) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindData(category: String, select: Boolean) {
            itemView.category.text = category
            changeStatus(select)
            itemView.category.setOnClickListener {
                itemClick(category)
            }
        }

        fun changeStatus(select: Boolean) {
            itemView.category.apply {
                if (select) changeTextColor(R.color.colorPrimary)
                else changeTextColor(R.color.news_333333)
            }
        }
    }
}