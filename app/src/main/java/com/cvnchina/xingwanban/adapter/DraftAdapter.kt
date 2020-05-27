package com.cvnchina.xingwanban.adapter

import android.widget.ImageView
import com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter
import com.aliyun.svideo.common.baseAdapter.BaseViewHolder
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.bean.DraftBean
import com.cvnchina.xingwanban.glide.GlideUtils

/**
 * Created by hecuncun on 2020-5-15
 */
class DraftAdapter :
    BaseQuickAdapter<DraftBean, BaseViewHolder>(R.layout.item_draft_list) {
    override fun convert(helper: BaseViewHolder, item: DraftBean?) {
        item ?: return
        helper.setText(R.id.tv_title, item.title)
        helper.setText(R.id.tv_tag,item.tags)
        helper.addOnClickListener(R.id.iv_start)
        helper.addOnClickListener(R.id.tv_edit)
        helper.addOnClickListener(R.id.iv_move)
        val viCover = helper.getView<ImageView>(R.id.iv_cover)
        GlideUtils.loadRoundImg(viCover, item.thumbnailPath, R.mipmap.ic_launcher, 8)

    }
}