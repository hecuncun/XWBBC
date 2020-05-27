package com.cvnchina.xingwanban.ui.activity

import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.adapter.LeftAdapter
import com.cvnchina.xingwanban.adapter.RightAdapter
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.bean.ContentSortBean
import com.cvnchina.xingwanban.event.SortEvent
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.net.CallbackListObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import kotlinx.android.synthetic.main.activity_sort.*
import kotlinx.android.synthetic.main.toolbar.*
import org.greenrobot.eventbus.EventBus

/**
 * Created by hecuncun on 2020-5-10
 */
class SortActivity : BaseActivity() {
    override fun attachLayoutRes(): Int = R.layout.activity_sort

    private var groupList = mutableListOf<ContentSortBean.DataBean.ChildrenBeanX>()

    private var childList = mutableListOf<ContentSortBean.DataBean.ChildrenBeanX.ChildrenBean>()

    override fun initData() {
        //获取分类
        val contentSortCall = SLMRetrofit.instance.api.contentSortCall()
        contentSortCall.compose(ThreadSwitchTransformer())
            .subscribe(object : CallbackListObserver<ContentSortBean>() {
                override fun onSucceed(t: ContentSortBean) {
                    groupList = t.data[0].children
                    childList= groupList[0].children
                    initLeftListView()
                }

                override fun onFailed() {

                }
            })

    }

    override fun initView() {
        toolbar_title.text = "内容分类"

    }

    private var leftAdapter: LeftAdapter? = null
    private var rightAdapter:RightAdapter?=null
    private fun initLeftListView() {
        leftAdapter = LeftAdapter(this, groupList)
        list_left.adapter = leftAdapter
        rightAdapter= RightAdapter(this,groupList[0].children)
        list_right.adapter=rightAdapter
    }

    override fun initListener() {
        list_left.setOnItemClickListener { parent, view, position, id ->
            (parent.adapter as LeftAdapter).setmCurSelectPosition(position)
            leftAdapter?.notifyDataSetChanged()
            childList = groupList[position].children
            rightAdapter?.setData(childList)
        }

        list_right.setOnItemClickListener { parent, view, position, id ->
            (parent.adapter as RightAdapter).setmCurSelectPosition(position)
            rightAdapter?.notifyDataSetChanged()
            EventBus.getDefault().post(SortEvent(childList[position].colId.toString(),childList[position].colName))
            showToast(childList[position].colName)
            finish()
        }
    }
}