package com.cvnchina.xingwanban.adapter

import android.widget.ImageView
import com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter
import com.aliyun.svideo.common.baseAdapter.BaseViewHolder
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.bean.MsgBean
import com.cvnchina.xingwanban.glide.GlideUtils

/**
 * Created by hecuncun on 2020-5-13
 */
class MsgAdapter : BaseQuickAdapter<MsgBean.RecordsBean, BaseViewHolder>(R.layout.item_msg_list) {
    override fun convert(helper: BaseViewHolder, item: MsgBean.RecordsBean?) {
        item ?: return
        helper.setText(R.id.tv_nick_name, item.nickName)
            .setText(R.id.tv_content, item.content)
            .setText(R.id.tv_date, item.createTime.split("T")[0])
        val ivVideo = helper.getView<ImageView>(R.id.iv_video)
        GlideUtils.showAnimation(ivVideo, item.videoPic, R.mipmap.ic_launcher)
       val ivHead = helper.getView<ImageView>(R.id.iv_head_photo)
        GlideUtils.showCircle(ivHead,item.headPic,R.mipmap.icon_sys)
        //1,点赞 2,评论；3，视频审核通过 4视频审核不通过
        var desc=""
        when(item.type){
            1->{  desc ="点赞了你的作品"}
            2->{  desc ="评论了你的作品"}
            3->{  desc ="你的作品审核通过"}
            4->{  desc ="你的作品视频审核不通过"}
        }

        helper.setText(R.id.tv_type,desc)
    }
}