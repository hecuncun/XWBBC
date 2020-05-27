package com.cvnchina.xingwanban.ui.activity

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.adapter.CommonProblemAdapter
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.bean.QABean
import com.cvnchina.xingwanban.net.CallbackObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import kotlinx.android.synthetic.main.activity_commom_problem.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by hecuncun on 2020-5-13
 */
class CommonProblemActivity : BaseActivity() {
    private var currentPage = 1
    private var total = 0
    private var pageSize = 10
    private var list = mutableListOf<QABean.RecordsBean>()
    private val commonProblemAdapter: CommonProblemAdapter by lazy {
        CommonProblemAdapter()
    }

    override fun attachLayoutRes() = R.layout.activity_commom_problem

    override fun initData() {
        //获取常见问题
        val commonProblemCall = SLMRetrofit.instance.api.commonProblemCall(currentPage, pageSize)
        commonProblemCall.compose(ThreadSwitchTransformer())
            .subscribe(object : CallbackObserver<QABean>() {
                override fun onSucceed(t: QABean, desc: String?) {
                    total = t.pages
                    list.addAll(t.records)
                    commonProblemAdapter.setNewData(list)
                }

                override fun onFailed() {
                }
            })
    }

    override fun initView() {
        toolbar_title.text = "常见问题"
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView.run {
            layoutManager = LinearLayoutManager(this@CommonProblemActivity)
            adapter = commonProblemAdapter
        }
    }

    override fun initListener() {
        commonProblemAdapter.disableLoadMoreIfNotFullPage(recyclerView)
        commonProblemAdapter.setOnLoadMoreListener(BaseQuickAdapter.RequestLoadMoreListener {
            if (total < 2) {
                commonProblemAdapter.setEnableLoadMore(false)
            }
            currentPage++
            if (currentPage > total) {
                return@RequestLoadMoreListener
            }

            val commonProblemCall = SLMRetrofit.instance.api.commonProblemCall(currentPage, pageSize)
            commonProblemCall.compose(ThreadSwitchTransformer())
                .subscribe(object : CallbackObserver<QABean>() {
                    override fun onSucceed(t: QABean, desc: String?) {
                        list.addAll(t.records)
                        commonProblemAdapter.setNewData(list)
                        if (currentPage==total){
                            commonProblemAdapter.loadMoreEnd()
                            commonProblemAdapter.setEnableLoadMore(false)
                        }else{
                            commonProblemAdapter.setEnableLoadMore(true)
                            commonProblemAdapter.loadMoreComplete()
                        }
                    }

                    override fun onFailed() {
                    }
                })


        }, recyclerView)



        commonProblemAdapter.setOnItemClickListener { adapter, view, position ->
            val intent = Intent(this@CommonProblemActivity,ProblemDetailActivity::class.java)
            intent.putExtra("q",  list[position].question)
            intent.putExtra("a",list[position].answer)
            startActivity(intent)
        }
    }
}