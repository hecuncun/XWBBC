package com.cvnchina.xingwanban.ui.activity

import android.support.v7.widget.LinearLayoutManager
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.adapter.LocationAdapter
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.bean.LocationBean
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.net.CallbackListObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import kotlinx.android.synthetic.main.avtivity_location.*
import kotlinx.android.synthetic.main.toolbar.*
import org.greenrobot.eventbus.EventBus

/**
 * Created by hecuncun on 2020-5-10
 */
class LocationActivity : BaseActivity() {
    private val locationAdapter: LocationAdapter by lazy {
        LocationAdapter()
    }
    private var list = mutableListOf<LocationBean.DataBean>()
    override fun attachLayoutRes(): Int = R.layout.avtivity_location

    override fun initData() {

    }

    override fun initView() {
        toolbar_title.text = "添加位置"
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView.run {
            layoutManager = LinearLayoutManager(this@LocationActivity)
            adapter = locationAdapter
        }
    }

    override fun initListener() {
        tv_search.setOnClickListener {
            val etLocation = et_location.text.toString().trim()
            if (etLocation.isEmpty()) {
                showToast("请输入位置")
            } else {
                //获取位置
                val locationCall = SLMRetrofit.instance.api.locationCall(etLocation)
                locationCall.compose(ThreadSwitchTransformer())
                    .subscribe(object : CallbackListObserver<LocationBean>() {
                        override fun onSucceed(t: LocationBean) {
                            list.clear()
                            list.addAll(t.data)
                            locationAdapter.setNewData(list)
                        }

                        override fun onFailed() {

                        }
                    })
            }
        }



        locationAdapter.setOnItemClickListener { adapter, view, position ->
            val dataBean = list[position]
            EventBus.getDefault().post(dataBean)
            finish()
        }
    }


}