package com.cvnchina.xingwanban.adapter

import com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter
import com.aliyun.svideo.common.baseAdapter.BaseViewHolder
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.bean.TalksBean

/**
 * Created by hecuncun on 2020-5-14
 */
class TalkAdapter : BaseQuickAdapter<TalksBean.DataBean, BaseViewHolder>(R.layout.item_talk_list) {
    override fun convert(helper: BaseViewHolder, item: TalksBean.DataBean?) {
        item ?: return
        helper.setText(R.id.tv_name, item.name)
            .setText(R.id.tv_hot, item.hot)
    }
}