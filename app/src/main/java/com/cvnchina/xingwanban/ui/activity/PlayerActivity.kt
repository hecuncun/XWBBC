package com.cvnchina.xingwanban.ui.activity

import android.view.View
import cn.jzvd.JzvdStd
import com.bumptech.glide.Glide
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.bean.WorksBean
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.widget.EvaluateDialog
import com.umeng.socialize.ShareAction
import com.umeng.socialize.UMShareListener
import com.umeng.socialize.bean.SHARE_MEDIA
import kotlinx.android.synthetic.main.activity_player.*

/**
 * Created by hecuncun on 2020-5-16
 */
class PlayerActivity : BaseActivity() {
    override fun attachLayoutRes(): Int = R.layout.activity_player
    private var workBean: WorksBean.ListBean? = null
    private var show=""//0 不显示  1 显示
    override fun initData() {
        workBean = intent.getParcelableExtra<WorksBean.ListBean>("listBean")
        show= intent.getStringExtra("show")!!
        if (workBean != null) {
            player.setUp(workBean!!.contDownUrl, "", JzvdStd.SCREEN_FULLSCREEN)
            Glide.with(this).load(workBean!!.overimageurl).into(player.thumbImageView)
            player.startVideo()
            player.backButton.visibility = View.GONE
            player.batteryTimeLayout.visibility = View.GONE
            player.fullscreenButton.visibility = View.INVISIBLE

            tv_zan.text = workBean!!.haszannums
            tv_evaluate.text = workBean!!.commentnums
            tv_title.text = workBean!!.contSubTitle
            // tv_nick_name.text=
            if (workBean!!.contTags.size > 0) {
                tv_tag.text = workBean!!.contTags[0].tagName
            }
        }

        val path = intent.getStringExtra("path")
        val pathImg = intent.getStringExtra("thumbnailPath")
        val title = intent.getStringExtra("title")
        val tags = intent.getStringExtra("tags")
        if (path!=null){
            player.setUp(path,"",JzvdStd.SCREEN_FULLSCREEN)
            Glide.with(this).load(pathImg).into(player.thumbImageView)
            player.startVideo()
            player.backButton.visibility = View.GONE
            player.batteryTimeLayout.visibility = View.GONE
            player.fullscreenButton.visibility = View.INVISIBLE
            tv_zan.visibility =View.GONE
            tv_evaluate.visibility = View.GONE
            tv_title.text = title
            tv_tag.text=tags
        }

    }

    override fun initView() {
        tv_nick_name.text=nickname
    }

    private var showContent = true
    override fun initListener() {
        iv_finish.setOnClickListener {
            finish()
        }

        tv_share.setOnClickListener {
            showToast("分享")
            ShareAction(this).withText("hello").setDisplayList(
                SHARE_MEDIA.SINA,
                SHARE_MEDIA.QQ,
                SHARE_MEDIA.WEIXIN
            )
                .setCallback(umShareListener).open()
        }
        ll_content.setOnClickListener {
            showContent = !showContent
            if (showContent) {
                tv_title.text = workBean!!.contSubTitle
                // tv_nick_name.text=
                if (workBean!!.contTags.size > 0) {
                    tv_tag.text = workBean!!.contTags[0].tagName
                }
            } else {
                tv_title.text = ""
                tv_tag.text = ""
            }
        }

        tv_evaluate.setOnClickListener {
                val evaluateDialog = EvaluateDialog(this)
                evaluateDialog.setVideoId(workBean!!.contId.toInt())
                evaluateDialog.show()

        }

        if (show=="1"){
            tv_evaluate.performClick()
        }
    }

    override fun onBackPressed() {
        if (JzvdStd.backPress()) {
            return
        }
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        JzvdStd.goOnPlayOnPause()
    }

    override fun onResume() {
        super.onResume()
        JzvdStd.goOnPlayOnResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        JzvdStd.releaseAllVideos()
    }

    private var umShareListener = object : UMShareListener {
        /**
         * @descrption 分享开始的回调
         */
        override fun onResult(p0: SHARE_MEDIA?) {//成功

        }

        override fun onCancel(p0: SHARE_MEDIA?) {

        }

        override fun onError(p0: SHARE_MEDIA?, p1: Throwable?) {

        }

        override fun onStart(p0: SHARE_MEDIA?) {

        }
    }
}