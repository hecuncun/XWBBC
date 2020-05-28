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
import com.cvnchina.xingwanban.bean.WorksBean
import com.cvnchina.xingwanban.event.RefreshWorksEvent
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.net.CallbackListObserver
import com.cvnchina.xingwanban.net.CallbackObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import com.cvnchina.xingwanban.ui.activity.PlayerActivity
import com.lhzw.bluetooth.base.BaseFragment
import com.umeng.socialize.ShareAction
import com.umeng.socialize.UMShareListener
import com.umeng.socialize.bean.SHARE_MEDIA
import kotlinx.android.synthetic.main.fragment_works.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Created by hecuncun on 2020-5-6
 */
class WorksFragment : BaseFragment() {
    private var currentPage = 0
    private var total = 0
    private var pageSize = 10
    private var listWorks = mutableListOf<WorksBean.ListBean>()
    override fun useEventBus(): Boolean=true
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

    override fun initListener() {
        worksAdapter.disableLoadMoreIfNotFullPage(rv_works)
        worksAdapter.setOnLoadMoreListener(BaseQuickAdapter.RequestLoadMoreListener {
            if (total < 2) {
                worksAdapter.setEnableLoadMore(false)
            }
            currentPage++
            if (currentPage > total) {
                return@RequestLoadMoreListener
            }
            val worksCall = SLMRetrofit.instance.api.worksCall(currentPage, pageSize)
            worksCall.compose(ThreadSwitchTransformer())
                .subscribe(object : CallbackObserver<WorksBean>() {
                    override fun onSucceed(t: WorksBean, desc: String?) {
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
            val palyer = adapter.getViewByPosition(position, R.id.jz_player) as JzvdStd
            val ivStart = adapter.getViewByPosition(position, R.id.iv_start) as ImageView
            when (view.id) {
                R.id.iv_start -> {
                    isPlaying = !isPlaying
                    if (isPlaying) {
                        ivStart.setImageResource(R.mipmap.icon_stop_play)
                        palyer.startButton.performClick()
                    } else {
                        palyer.startButton.performClick()
                        ivStart.setImageResource(R.mipmap.icon_play)
                    }
                    // worksAdapter.notifyItemChanged(position)

                }
                R.id.tv_cover -> {
                    val intent = Intent(activity, PlayerActivity::class.java)
                    intent.putExtra("listBean", listBean)
                    intent.putExtra("show","0")
                    startActivity(intent)
                }
                R.id.iv_share -> {
                    ShareAction(activity).withText("hello").setDisplayList(
                        SHARE_MEDIA.SINA,
                        SHARE_MEDIA.QQ,
                        SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();
                }
                R.id.tv_more->{
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
        val worksCall = SLMRetrofit.instance.api.worksCall(currentPage, pageSize)
        worksCall.compose(ThreadSwitchTransformer())
            .subscribe(object : CallbackObserver<WorksBean>() {
                override fun onSucceed(t: WorksBean, desc: String?) {
                    total = t.pages
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
        lazyLoad()
    }
}