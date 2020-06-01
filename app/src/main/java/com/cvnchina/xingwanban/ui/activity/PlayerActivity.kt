package com.cvnchina.xingwanban.ui.activity

import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.RelativeLayout
import cn.jzvd.JzvdStd
import com.bumptech.glide.Glide
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.application.App
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.bean.ShareBean
import com.cvnchina.xingwanban.bean.WorksBean
import com.cvnchina.xingwanban.net.CallbackListObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import com.cvnchina.xingwanban.utils.StatusBarUtil
import com.cvnchina.xingwanban.widget.EvaluateDialog
import com.cvnchina.xingwanban.widget.ShareDialog
import com.umeng.socialize.ShareAction
import com.umeng.socialize.UMShareListener
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.media.UMImage
import com.umeng.socialize.media.UMVideo
import kotlinx.android.synthetic.main.activity_player.*

/**
 * Created by hecuncun on 2020-5-16
 */
class PlayerActivity : BaseActivity() {
    private var shareDialog: ShareDialog?=null
    override fun attachLayoutRes(): Int = R.layout.activity_player
    private var workBean: WorksBean.ListBean? = null
    private var show=""//0 不显示  1 显示
    private var title=""
    private var tags=""

    override fun initStateBarColor() {
        val mThemeColor = App.context.resources.getColor(R.color.transparent)//设置状态栏颜色
        StatusBarUtil.setColor(this, mThemeColor, 100)
        if (this.supportActionBar != null) {
            this.supportActionBar?.setBackgroundDrawable(ColorDrawable(mThemeColor))
        }
    }
    override fun initData() {
        workBean = intent.getParcelableExtra<WorksBean.ListBean>("listBean")
        show= intent.getStringExtra("show")!!
        JzvdStd.setVideoImageDisplayType(JzvdStd.VIDEO_IMAGE_DISPLAY_TYPE_FILL_PARENT)
        (player.titleTextView.parent as RelativeLayout).background=null
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
            title=workBean!!.contSubTitle
            // tv_nick_name.text=
            if (workBean!!.contTags.size > 0) {
                tv_tag.text = workBean!!.contTags[0].tagName
                tags=workBean!!.contTags[0].tagName
            }
        }

        val path = intent.getStringExtra("path")
        val pathImg = intent.getStringExtra("thumbnailPath")
        val titlex = intent.getStringExtra("title")
        val tag = intent.getStringExtra("tags")
        if (path!=null){
            player.setUp(path,"",JzvdStd.SCREEN_FULLSCREEN)
            Glide.with(this).load(pathImg).into(player.thumbImageView)
            player.startVideo()
            player.backButton.visibility = View.GONE
            player.batteryTimeLayout.visibility = View.GONE
            player.fullscreenButton.visibility = View.INVISIBLE
            tv_zan.visibility =View.GONE
            tv_evaluate.visibility = View.GONE
            tv_share.visibility=View.GONE
            tv_title.text = titlex
            tv_tag.text=tag
            tags=tag
            title=titlex
        }

    }


    override fun initView() {
        tv_nick_name.text="@$nickname"
        shareDialog= ShareDialog(this,false)
    }

    private var showContent = true
    override fun initListener() {
        iv_finish.setOnClickListener {
            finish()
        }

        tv_share.setOnClickListener {
            shareDialog?.setOnChoseListener(object :ShareDialog.OnChoseListener{
                override fun select(resId: Int) {
                    when(resId){
                        R.id.ll_wx->{
                            requestShare(1,2,workBean!!.contId.toInt())
                        }
                        R.id.ll_wx_c->{
                            requestShare(2,2,workBean!!.contId.toInt())
                        }
                        R.id.ll_wb->{
                            requestShare(3,2,workBean!!.contId.toInt())
                        }
                        R.id.ll_qq->{
                            requestShare(4,2,workBean!!.contId.toInt())
                        }
                        R.id.ll_qq_c->{
                            requestShare(5,2,workBean!!.contId.toInt())
                        }
                        else->{

                        }

                    }

                    shareDialog?.dismiss()
                }
            })

            shareDialog?.show()
        }
        ll_content.setOnClickListener {
            showContent = !showContent
            if (showContent) {
                tv_title.text = title
                tv_nick_name.text="@$nickname"
                // tv_nick_name.text=
                    tv_tag.text = tags
                    tv_tag.background= resources.getDrawable(R.drawable.bg_gray_26ffffff_r4)

            } else {
                tv_nick_name.text=""
                tv_title.text = ""
                tv_tag.text = ""
                tv_tag.background=null
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
    private fun requestShare(platform: Int, type: Int, videoId: Int) {
        //分享到平台1-微信；2-朋友圈；3-微博；4-QQ好友；5.QQ空间  1-app分享 2-视频分享
        val shareVideoCall = SLMRetrofit.instance.api.shareVideoCall(
            platform,
            type,
            videoId
        )
        shareVideoCall.compose(ThreadSwitchTransformer()).subscribe(object :CallbackListObserver<ShareBean>(){
            override fun onSucceed(t: ShareBean?) {
                val video = UMVideo(t?.url)
                video.title ="  " //视频的标题
                var thumb= UMImage(this@PlayerActivity,workBean!!.overimageurl)
                video.setThumb(thumb) //视频的缩略图
                video.description = workBean?.contSubTitle //视频的描述
                when(platform){
                    1->{
                        ShareAction(this@PlayerActivity).setPlatform(SHARE_MEDIA.WEIXIN).withMedia(video).setCallback(umShareListener).share()
                    }
                    2->{
                        ShareAction(this@PlayerActivity).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE).withMedia(video).setCallback(umShareListener).share()
                    }
                    3->{
                        ShareAction(this@PlayerActivity).setPlatform(SHARE_MEDIA.SINA).withMedia(video).setCallback(umShareListener).share()
                    }
                    4->{
                        ShareAction(this@PlayerActivity).setPlatform(SHARE_MEDIA.QQ).withMedia(video).setCallback(umShareListener).share()
                    }
                    5->{
                        ShareAction(this@PlayerActivity).setPlatform(SHARE_MEDIA.QZONE).withMedia(video).setCallback(umShareListener).share()
                    }

                }

            }

            override fun onFailed() {

            }
        })
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