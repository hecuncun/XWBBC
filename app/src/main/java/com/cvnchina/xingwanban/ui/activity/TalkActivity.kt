package com.cvnchina.xingwanban.ui.activity

import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.adapter.TalkAdapter
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.bean.TalksBean
import com.cvnchina.xingwanban.event.TalkEvent
import com.cvnchina.xingwanban.net.CallbackListObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import kotlinx.android.synthetic.main.activity_talk.*
import org.greenrobot.eventbus.EventBus

/**
 * Created by hecuncun on 2020-5-10
 */
class TalkActivity : BaseActivity() {
    private val talkAdapter:TalkAdapter by lazy {
        TalkAdapter()
    }
    override fun attachLayoutRes(): Int {
        return R.layout.activity_talk
    }

    override fun initData() {
        val talksCall = SLMRetrofit.instance.api.talksCall("")
        talksCall.compose(ThreadSwitchTransformer())
            .subscribe(object : CallbackListObserver<TalksBean>() {
                override fun onSucceed(t: TalksBean) {
                    if (t.data.isNotEmpty()){
                        list.addAll(t.data)
                        talkAdapter.setNewData(list)
                        ll_create_talk.visibility= View.GONE
                    }

                }

                override fun onFailed() {

                }
            })
    }

    override fun initView() {
        initRecyclerView()

    }
    private fun initRecyclerView() {
        recyclerView.run {
            layoutManager = LinearLayoutManager(this@TalkActivity)
            adapter = talkAdapter
        }
    }

    private var name = ""
    private var list = mutableListOf<TalksBean.DataBean>()
    override fun initListener() {
        talkAdapter.setOnItemClickListener { adapter, view, position ->
            val talk= list[position].name
            EventBus.getDefault().post(TalkEvent(talk))
            finish()
        }

        ll_create_talk.setOnClickListener {
            EventBus.getDefault().post(TalkEvent(name))
            finish()
        }
        tv_finish.setOnClickListener {
            finish()
        }

        et_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                //编辑完就搜索
                name = s.toString().trim()
                val talksCall = SLMRetrofit.instance.api.talksCall(name)
                talksCall.compose(ThreadSwitchTransformer())
                    .subscribe(object : CallbackListObserver<TalksBean>() {
                        override fun onSucceed(t: TalksBean) {
                            if (t.data.isNotEmpty()){
                                list.clear()
                                list.addAll(t.data)
                                talkAdapter.setNewData(list)
                                ll_create_talk.visibility= View.GONE
                            }else{
                                list.clear()
                                talkAdapter.setNewData(list)
                                tv_create_talk.text="创建新话题：$name"
                                ll_create_talk.visibility= View.VISIBLE
                            }

                        }

                        override fun onFailed() {

                        }
                    })
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }
}