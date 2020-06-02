package com.cvnchina.xingwanban.ui.activity

import android.support.v7.widget.LinearLayoutManager
import com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.adapter.MsgAdapter
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.bean.MsgBean
import com.cvnchina.xingwanban.net.CallbackObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import kotlinx.android.synthetic.main.activity_msg.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by hecuncun on 2020-5-10
 */
class MsgActivity : BaseActivity() {
    private var currentPage = 1
    private var total = 0
    private var pageSize = 10
    private var list = mutableListOf<MsgBean.RecordsBean>()
    private val msgAdapter: MsgAdapter by lazy {
        MsgAdapter()
    }

    override fun attachLayoutRes(): Int = R.layout.activity_msg

    override fun initData() {
        //获取消息列表
        val msgListCall = SLMRetrofit.instance.api.msgListCall(currentPage, pageSize)
        msgListCall.compose(ThreadSwitchTransformer())
            .subscribe(object : CallbackObserver<MsgBean>() {
                override fun onSucceed(t: MsgBean, desc: String?) {
                    total=t.pages
                    list.addAll(t.records)
                    msgAdapter.setNewData(list)
                }

                override fun onFailed() {

                }
            })

    }

    override fun initView() {
        toolbar_title.text = "消息"
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView.run {
            layoutManager=LinearLayoutManager(this@MsgActivity)
            adapter=msgAdapter
        }
    }

    override fun initListener() {
        msgAdapter.disableLoadMoreIfNotFullPage(recyclerView)
        msgAdapter.setOnLoadMoreListener(BaseQuickAdapter.RequestLoadMoreListener {
            if (total < 2) {
                msgAdapter.setEnableLoadMore(false)
                return@RequestLoadMoreListener
            }
            currentPage++
            if (currentPage > total) {
                return@RequestLoadMoreListener
            }

            val msgListCall = SLMRetrofit.instance.api.msgListCall(currentPage, pageSize)
            msgListCall.compose(ThreadSwitchTransformer())
                .subscribe(object : CallbackObserver<MsgBean>() {
                    override fun onSucceed(t: MsgBean, desc: String?) {
                        list.addAll(t.records)
                        msgAdapter.setNewData(list)
                        if (currentPage==total){
                            msgAdapter.loadMoreEnd()
                            msgAdapter.setEnableLoadMore(false)
                        }else{
                            msgAdapter.setEnableLoadMore(true)
                            msgAdapter.loadMoreComplete()
                        }
                    }

                    override fun onFailed() {
                    }
                })


        }, recyclerView)
    }
}