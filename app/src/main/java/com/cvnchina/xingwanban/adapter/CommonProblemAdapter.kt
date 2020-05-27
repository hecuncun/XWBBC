package com.cvnchina.xingwanban.adapter

import com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter
import com.aliyun.svideo.common.baseAdapter.BaseViewHolder
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.bean.QABean

/**
 * Created by hecuncun on 2020-5-13
 */
class CommonProblemAdapter:BaseQuickAdapter<QABean.RecordsBean,BaseViewHolder>(R.layout.item_problem_list) {
    override fun convert(helper: BaseViewHolder, item: QABean.RecordsBean?) {
        item?:return
       helper.setText(R.id.tv_a,item.answer)
           .setText(R.id.tv_q,item.question)

    }
}