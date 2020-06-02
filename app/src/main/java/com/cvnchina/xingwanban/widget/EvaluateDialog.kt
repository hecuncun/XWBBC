package com.cvnchina.xingwanban.widget

import android.content.Context
import android.support.design.widget.BottomSheetDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.ExpandableListView
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.adapter.CommentExpandAdapter
import com.cvnchina.xingwanban.base.BaseNoDataBean
import com.cvnchina.xingwanban.bean.EvaluateListBean
import com.cvnchina.xingwanban.bean.ReplyListBean
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.net.CallbackListObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import com.cvnchina.xingwanban.utils.BeanUtils
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.dialog_evaluate.*


/**
 * Created by hecuncun on 2020-5-16
 * 去掉阴影
 */
class EvaluateDialog(context: Context) : BottomSheetDialog(context,R.style.TransBottomSheetDialogStyle), View.OnClickListener {
    init {
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_evaluate, null)
        setContentView(view)
        iv_close.setOnClickListener(this)
        tv_send.setOnClickListener(this)
        setCancelable(false)

    }


    private var videoId = 0
    private var currentPage =1
    private var total = 0
    private var pageSize = 3000000


    private var mAdapter: CommentExpandAdapter? = null


    fun setVideoId(id: Int) {
        videoId = id

        initData()
    }

    private var list = mutableListOf<EvaluateListBean.DataBean.ItemsBean>()
    private fun initData() {
        //根据视频id,获取评论列表
        val evaluateListCall =
            SLMRetrofit.instance.api.evaluateListCall(videoId, currentPage, pageSize)
        evaluateListCall.compose(ThreadSwitchTransformer())
            .subscribe(object : CallbackListObserver<EvaluateListBean>() {
                override fun onSucceed(t: EvaluateListBean) {
                    if (t.msg == "1") {

                        tv_num.text = "${t.data.total} 条评论"

                        list = t.data.items
                        if (list.isEmpty()) {
                            return
                        }

                        listview.setGroupIndicator(null)
                        mAdapter = CommentExpandAdapter(context, list)
                        listview.setAdapter(mAdapter)
                        for (i in list.indices) {
                            listview.expandGroup(i)
                        }
                        listview.setOnGroupClickListener(object :
                            ExpandableListView.OnGroupClickListener {
                            override fun onGroupClick(
                                parent: ExpandableListView?,
                                v: View?,
                                groupPosition: Int,
                                id: Long
                            ): Boolean {
                                commentId = list[groupPosition].id
                                Logger.e("onGroupClick: 当前的评论id>${list[groupPosition].id}")
                                et_content.hint="回复${list[groupPosition].userNickName}："
                                return true
                            }
                        })

                        listview.setOnChildClickListener(object :
                            ExpandableListView.OnChildClickListener {
                            override fun onChildClick(
                                parent: ExpandableListView?,
                                v: View?,
                                groupPosition: Int,
                                childPosition: Int,
                                id: Long
                            ): Boolean {
                                Logger.e("点击了回复$childPosition")
                                if (childPosition==1){
                                    val replayListCall = SLMRetrofit.instance.api.replayListCall(
                                        list[groupPosition].id,
                                        1,
                                        list[groupPosition].childCommentCount
                                    )
                                    replayListCall.compose(ThreadSwitchTransformer()).subscribe(object :
                                        CallbackListObserver<ReplyListBean>(){

                                        override fun onFailed() {

                                        }

                                        override fun onSucceed(t: ReplyListBean) {
                                            if (t.msg=="1"){
                                                var list =t.data.items
                                                var listReply= mutableListOf<EvaluateListBean.DataBean.ItemsBean.ChildCommentBean>()
                                                for ( item in list){
                                                    val bean = BeanUtils.modelA2B(
                                                        item,
                                                        EvaluateListBean.DataBean.ItemsBean.ChildCommentBean::class.java
                                                    )
                                                    listReply.add(bean)
                                                }
                                                mAdapter?.addReplyList(listReply,groupPosition)
                                            }

                                        }
                                    })
                                }
                                return true
                            }
                        })



                    }


                }

                override fun onFailed() {

                }
            })
    }

    private var commentId = -1
    override fun onClick(v: View) {
        when (v.id) {
            R.id.iv_close -> {
                dismiss()
            }
            R.id.tv_send -> {//发送
                if (et_content.text.toString().isNotEmpty()) {
                    if (commentId == -1) {
                        context.showToast("请点击要评论的内容")
                    } else {//回复评论
                        val replayCall = SLMRetrofit.instance.api.replayCall(
                            commentId,
                            et_content.text.toString().trim()
                        )
                        replayCall.compose(ThreadSwitchTransformer())
                            .subscribe(object : CallbackListObserver<BaseNoDataBean>() {
                                override fun onSucceed(t: BaseNoDataBean) {
                                    if (t.msg == "1") {
                                        context.showToast("评论成功")
                                        et_content.setText("")
                                        initData()
                                    }
                                }

                                override fun onFailed() {

                                }
                            })
                    }
                } else {
                    context.showToast("请输入评论")
                }
            }
        }
    }
}