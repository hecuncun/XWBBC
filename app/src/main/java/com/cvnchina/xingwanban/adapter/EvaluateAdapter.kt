package com.cvnchina.xingwanban.adapter

import android.widget.ImageView
import com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter
import com.aliyun.svideo.common.baseAdapter.BaseViewHolder
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.bean.WorksBean
import com.cvnchina.xingwanban.glide.GlideUtils

/**
 * Created by hecuncun on 2020-5-15
 */
class EvaluateAdapter:BaseQuickAdapter<WorksBean.ListBean.HotCommentBean,BaseViewHolder>(R.layout.item_evaluate) {
    override fun convert(helper: BaseViewHolder, item: WorksBean.ListBean.HotCommentBean?) {
        item?:return
        helper.setText(R.id.tv_name,item.userNickName)
            .setText(R.id.tv_content,item.content)
        val view = helper.getView<ImageView>(R.id.iv_head_photo)
        GlideUtils.showCircle(view,item.userHeadPic,R.mipmap.icon_def_head)

    }
}