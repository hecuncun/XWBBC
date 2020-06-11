package com.cvnchina.xingwanban.adapter

import android.widget.ImageView
import android.widget.TextView
import com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter
import com.aliyun.svideo.common.baseAdapter.BaseViewHolder
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.bean.DraftBean
import com.cvnchina.xingwanban.glide.GlideUtils
import com.cvnchina.xingwanban.utils.CommonUtil

/**
 * Created by hecuncun on 2020-5-15
 */
class DraftAdapter :
    BaseQuickAdapter<DraftBean, BaseViewHolder>(R.layout.item_draft_list) {
    override fun convert(helper: BaseViewHolder, item: DraftBean?) {
        item ?: return
        helper.setText(R.id.tv_title, item.title)
        helper.setText(R.id.tv_tag,item.tags)
      val tvTag =  helper.getView<TextView>(R.id.tv_tag)
        if(item.tags.isEmpty()){
            tvTag.background=null
        }else{
            tvTag.setBackgroundResource(R.drawable.bg_gray_151516_r5)
        }
        val ls = CommonUtil.getLocalVideoDuration(item.path)/1000;
        var hour =  (ls/3600)
        var minute = (ls%3600)/60;
        var second = (ls-hour*3600-minute*60)
        var min=""
        var sec=""
        if(minute<10){
            min="0$minute"
        }else{
            min=minute.toString()
        }
        if(second<10){
            sec="0$second"
        }else{
            sec=second.toString()
        }
        helper.setText(R.id.tv_time,"$min:$sec")
        helper.addOnClickListener(R.id.tv_edit)
        helper.addOnClickListener(R.id.iv_move)
        helper.addOnClickListener(R.id.iv_cover)
        val viCover = helper.getView<ImageView>(R.id.iv_cover)
        GlideUtils.loadRoundImg(viCover, item.thumbnailPath, R.mipmap.ic_launcher, 8)

    }
}