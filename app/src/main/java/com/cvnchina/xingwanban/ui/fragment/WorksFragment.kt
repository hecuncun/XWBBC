package com.cvnchina.xingwanban.ui.fragment

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.ImageView
import cn.jzvd.JzvdStd
import com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.adapter.WorksAdapter
import com.cvnchina.xingwanban.base.BaseNoDataBean
import com.cvnchina.xingwanban.bean.ShareBean
import com.cvnchina.xingwanban.bean.WorksBean
import com.cvnchina.xingwanban.event.RefreshWorksEvent
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.net.CallbackListObserver
import com.cvnchina.xingwanban.net.CallbackObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import com.cvnchina.xingwanban.ui.activity.PlayerActivity
import com.cvnchina.xingwanban.widget.ShareDialog
import com.lhzw.bluetooth.base.BaseFragment
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.umeng.socialize.ShareAction
import com.umeng.socialize.UMShareAPI
import com.umeng.socialize.UMShareListener
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.media.UMImage
import com.umeng.socialize.media.UMVideo
import kotlinx.android.synthetic.main.fragment_works.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


/**
 * Created by hecuncun on 2020-5-6
 */
class WorksFragment : BaseFragment() {
    private var currentPage =1
    private var total = 0//总页数
    private var pageSize = 10
    private var listWorks = mutableListOf<WorksBean.ListBean>()

    private var currentBean :WorksBean.ListBean?=null
    override fun useEventBus(): Boolean=true

    private var shareDialog:ShareDialog?=null
    private val worksAdapter: WorksAdapter by lazy {
        WorksAdapter()
    }

    companion object {
        fun getInstance(): WorksFragment = WorksFragment()
    }

    override fun attachLayoutRes(): Int {
        return R.layout.fragment_works
    }

    override fun initView(view: View) {
        initRv()

    }

    private var isPlaying = false
    private var last =-1
    override fun initListener() {

        refreshLayout.setRefreshHeader(ClassicsHeader(activity))
        refreshLayout.setDragRate(3f)
           refreshLayout.setOnRefreshListener {
               com.orhanobut.logger.Logger.e("刷新列表")
               currentPage=1
               total=0
               refreshLayout.finishRefresh(2000)
               lazyLoad()
           }
        worksAdapter.disableLoadMoreIfNotFullPage(rv_works)
        worksAdapter.setOnLoadMoreListener(BaseQuickAdapter.RequestLoadMoreListener {
            if (total < 2) {
                worksAdapter.setEnableLoadMore(false)
                return@RequestLoadMoreListener
            }
            currentPage++
            if (currentPage > total) {
                return@RequestLoadMoreListener
            }

            val worksCall = SLMRetrofit.instance.api.worksCall(currentPage, pageSize)
            worksCall.compose(ThreadSwitchTransformer())
                .subscribe(object : CallbackObserver<WorksBean>() {
                    override fun onSucceed(t: WorksBean, desc: String?) {
                        com.orhanobut.logger.Logger.e("加载更多currentPage==$currentPage,${t.list.size}")
                        listWorks.addAll(t.list)
                        worksAdapter.setNewData(listWorks)
                        if (currentPage == total) {
                            worksAdapter.loadMoreEnd()
                            worksAdapter.setEnableLoadMore(false)
                        } else {
                            worksAdapter.setEnableLoadMore(true)
                            worksAdapter.loadMoreComplete()
                        }
                    }

                    override fun onFailed() {

                    }
                })

        }, rv_works)

        worksAdapter.setOnItemChildClickListener { adapter, view, position ->
            val listBean = adapter.getItem(position) as WorksBean.ListBean
            currentBean=listBean
            val palyer = adapter.getViewByPosition(position, R.id.jz_player) as JzvdStd
            val ivStart = adapter.getViewByPosition(position, R.id.iv_start) as ImageView
            when (view.id) {
                R.id.iv_start -> {
                    if (last<0){
                        last=position
                        isPlaying=true
                        ivStart.setImageResource(R.mipmap.icon_stop_play)
                        palyer.startButton.performClick()
                        return@setOnItemChildClickListener
                    }
                    if (position==last){
                        isPlaying = !isPlaying
                        if (isPlaying) {
                            ivStart.setImageResource(R.mipmap.icon_stop_play)
                            palyer.startButton.performClick()
                        } else {
                            palyer.startButton.performClick()
                            ivStart.setImageResource(R.mipmap.icon_play)
                        }
                        return@setOnItemChildClickListener
                    }
                    if (last!=position){
                        isPlaying=true
                        palyer.startButton.performClick()
                        ivStart.setImageResource(R.mipmap.icon_stop_play)

                        val lastStart = adapter.getViewByPosition(last, R.id.iv_start) as ImageView
                        lastStart.setImageResource(R.mipmap.icon_play)
                        //worksAdapter.notifyItemChanged(last)
                        last=position
                    }

                    // worksAdapter.notifyItemChanged(position)

                }
                R.id.tv_cover -> {
                    isPlaying=false
                    try {
                        val lastStart = adapter.getViewByPosition(last, R.id.iv_start) as ImageView
                        lastStart.setImageResource(R.mipmap.icon_play)
                    }catch (e:Exception){

                    }
                    last=-1
                    ivStart.setImageResource(R.mipmap.icon_play)
                    val intent = Intent(activity, PlayerActivity::class.java)
                    intent.putExtra("listBean", listBean)
                    intent.putExtra("show","0")
                    startActivity(intent)
                    worksAdapter.notifyItemChanged(position)
                }
                R.id.iv_share -> {
                    shareDialog= ShareDialog(activity!!,true,listBean.ischeck=="y")
                    shareDialog?.setOnChoseListener(object :ShareDialog.OnChoseListener{
                        override fun select(resId: Int) {
                            when(resId){
                                R.id.ll_del_video->{
                                    //删除视频
                                    //移除除视频
                                    val removeVideoCall =
                                        SLMRetrofit.instance.api.deleteVideoCall(listBean.contId)
                                    removeVideoCall.compose(ThreadSwitchTransformer())
                                        .subscribe(object : CallbackListObserver<BaseNoDataBean>() {
                                            override fun onSucceed(t: BaseNoDataBean) {
                                                if (t.msg == "1") {
                                                    showToast("删除成功")
                                                    worksAdapter.remove(position)
                                                    if (worksAdapter.data.size==0){
                                                        ll_empty_view.visibility = View.VISIBLE
                                                    }else{
                                                        ll_empty_view.visibility = View.GONE
                                                    }
                                                } else {
                                                    showToast(t.msgCondition)
                                                }
                                            }

                                            override fun onFailed() {

                                            }
                                        })
                                }

                                R.id.ll_wx->{
                                    requestShare(1,2,listBean.contId.toInt())
                                }
                                R.id.ll_wx_c->{
                                    requestShare(2,2,listBean.contId.toInt())
                                }
                                R.id.ll_wb->{
                                    requestShare(3,2,listBean.contId.toInt())
                                }
                                R.id.ll_qq->{
                                    requestShare(4,2,listBean.contId.toInt())
                                }
                                R.id.ll_qq_c->{
                                    requestShare(5,2,listBean.contId.toInt())
                                }

                            }

                            shareDialog?.dismiss()
                        }
                    })

                    shareDialog?.show()

                }
                R.id.tv_more->{
                    isPlaying=false
                    try {
                        val lastStart = adapter.getViewByPosition(last, R.id.iv_start) as ImageView
                        lastStart.setImageResource(R.mipmap.icon_play)
                    }catch (e:Exception){

                    }
                    last=-1
                    ivStart.setImageResource(R.mipmap.icon_play)
                    worksAdapter.notifyItemChanged(position)
                    val intent = Intent(activity, PlayerActivity::class.java)
                    intent.putExtra("listBean", listBean)
                    intent.putExtra("show","1")
                    startActivity(intent)
                }
                R.id.iv_move -> {
                    //移除除视频
                    val removeVideoCall =
                        SLMRetrofit.instance.api.deleteVideoCall(listBean.contId)
                    removeVideoCall.compose(ThreadSwitchTransformer())
                        .subscribe(object : CallbackListObserver<BaseNoDataBean>() {
                            override fun onSucceed(t: BaseNoDataBean) {
                                if (t.msg == "1") {
                                    showToast("删除成功")
                                    worksAdapter.remove(position)
                                    if (worksAdapter.data.size==0){
                                        ll_empty_view.visibility = View.VISIBLE
                                    }else{
                                        ll_empty_view.visibility = View.GONE
                                    }
                                } else {
                                    showToast(t.msgCondition)
                                }
                            }

                            override fun onFailed() {

                            }
                        })
                }
            }

        }
    }
//重新显示
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!isHidden){
            lazyLoad()
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
                video.title ="$nickname 给你分享了一个视频" //视频的标题
                var thumb= UMImage(activity,currentBean?.overimageurl)
                video.setThumb(thumb) //视频的缩略图
                video.description = currentBean?.contSubTitle //视频的描述
           when(platform){
               1->{
                ShareAction(activity).setPlatform(SHARE_MEDIA.WEIXIN).withMedia(video).setCallback(umShareListener).share()
               }
               2->{
                   ShareAction(activity).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE).withMedia(video).setCallback(umShareListener).share()
               }
               3->{
                   ShareAction(activity).setPlatform(SHARE_MEDIA.SINA).withMedia(video).setCallback(umShareListener).share()
               }
              4->{
                  ShareAction(activity).setPlatform(SHARE_MEDIA.QQ).withMedia(video).setCallback(umShareListener).share()
               }
               5->{
                   ShareAction(activity).setPlatform(SHARE_MEDIA.QZONE).withMedia(video).setCallback(umShareListener).share()
               }

           }

     }

            override fun onFailed() {

            }
        })
    }

    override fun lazyLoad() {
        listWorks.clear()
        //获取Demo  TODO 新隐藏
//        val demoWorksCall = SLMRetrofit.instance.api.demoWorksCall()
//        demoWorksCall.compose(ThreadSwitchTransformer())
//            .subscribe(object : CallbackListObserver<DemoWorksBean>() {
//                override fun onSucceed(t: DemoWorksBean) {
//                    if (t.msg == "1") {
//                        for (item in t.data) {
//                            val bean = BeanUtils.modelA2B(item, WorksBean.ListBean::class.java)
//                            bean.canDelete=true
//                            listWorks.add(bean)
//                        }
//                        worksAdapter.setNewData(listWorks)
//                        if (listWorks.isEmpty()) {
//                            ll_empty_view.visibility = View.VISIBLE
//                        } else {
//                            ll_empty_view.visibility = View.GONE
//                        }
//                    }
//                }
//
//                override fun onFailed() {
//
//                }
//
//            })
        //获取视频列表
        if (isLogin){
            val worksCall = SLMRetrofit.instance.api.worksCall(currentPage, pageSize)
            worksCall.compose(ThreadSwitchTransformer())
                .subscribe(object : CallbackObserver<WorksBean>() {
                    override fun onSucceed(t: WorksBean, desc: String?) {
                        total = t.pages
                        com.orhanobut.logger.Logger.e("初始化currentPage==$currentPage,${t.list.size}")
                        listWorks.addAll(t.list)
                        worksAdapter.setNewData(listWorks)
                        if (listWorks.isEmpty()) {
                            ll_empty_view.visibility = View.VISIBLE
                        } else {
                            ll_empty_view.visibility = View.GONE
                        }
                    }

                    override fun onFailed() {

                    }
                })
        }


    }

    private fun initRv() {

        rv_works.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = worksAdapter
        }
    }
    private var umShareListener =object : UMShareListener {
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun refreshList(event:RefreshWorksEvent){
        currentPage=1
        total=0
        lazyLoad()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        UMShareAPI.get(activity).onActivityResult(requestCode,resultCode,data)
    }
}