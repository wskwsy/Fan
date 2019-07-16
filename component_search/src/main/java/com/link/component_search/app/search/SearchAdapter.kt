package com.link.component_search.app.search

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.link.component_search.R

class SearchAdapter(layoutResId: Int, data: MutableList<String>?): BaseQuickAdapter<String, BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper!!.setText(R.id.name,item!!)
    }
}