package com.idisfkj.newskotlin.main.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.view.ViewGroup
import com.idisfkj.newskotlin.NewsConfig
import com.idisfkj.newskotlin.category.NewsCategoryFragment

/**
 * Created by idisfkj on 2017/8/16.
 * Email : idisfkj@gmail.com.
 */
class MainFragmentAdapter(var fm: FragmentManager?, var list: List<String> = NewsConfig.DEFAULT_CATEGORY) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return NewsCategoryFragment.newInstance(list[position])
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return list[position]
    }

    override fun getItemPosition(`object`: Any?): Int {
        return PagerAdapter.POSITION_NONE
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val fragment = fm?.findFragmentByTag(container?.id?.let { makeFragmentName(it, getItemId(position)) })
        if (fragment is NewsCategoryFragment && !fragment.id.equals(list[position])) {
            fm?.beginTransaction()?.remove(fragment)?.commit()
            fm?.executePendingTransactions()
        }
        return super.instantiateItem(container, position)
    }

    fun makeFragmentName(viewId: Int, id: Long): String {
        return "android:switcher:$viewId:$id"
    }
}