package com.cvnchina.xingwanban.ui.fragment

import android.content.Intent
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.aliyun.svideo.media.MediaInfo
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.adapter.DraftAdapter
import com.cvnchina.xingwanban.bean.DraftBean
import com.cvnchina.xingwanban.event.RefreshDraftEvent
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.ui.activity.PlayerActivity
import com.cvnchina.xingwanban.widget.DeleteDialog
import com.lhzw.bluetooth.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_draft.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.litepal.LitePal
import java.util.*

/**
 * Created by hecuncun on 2020-5-6
 */
class DraftFragment : BaseFragment() {
    override fun useEventBus(): Boolean=true
    private var deleteDialog:DeleteDialog?=null
    companion object {
        fun getInstance(): DraftFragment = DraftFragment()
    }

    override fun attachLayoutRes(): Int {
        return R.layout.fragment_draft
    }

    private var list = mutableListOf<DraftBean>()
    override fun initView(view: View) {
        deleteDialog= DeleteDialog(activity!!)
        initRv()
    }

    override fun initListener() {
        mAdapter.setOnItemChildClickListener { adapter, view, position ->
            val draftBean = adapter.getItem(position) as DraftBean
            when (view.id) {
                R.id.iv_cover -> {
                    val intent = Intent(activity, PlayerActivity::class.java)
                    intent.putExtra("path",draftBean.path)
                    intent.putExtra("show","0")
                    intent.putExtra("thumbnailPath",draftBean.thumbnailPath)
                    intent.putExtra("title",draftBean.title)
                    intent.putExtra("tags",draftBean.tags)
                    startActivity(intent)
                }
                R.id.tv_edit -> {
                    //进入视频编辑页
                    // 跳转到下一个页面
                    val mediaInfo= MediaInfo()
                    mediaInfo.filePath = draftBean.path
                    mediaInfo.mimeType="video"
                    val infoList: ArrayList<MediaInfo> = ArrayList<com.aliyun.svideo.media.MediaInfo>()
                    infoList.add(mediaInfo)
                    val intent = Intent()
                    intent.setClassName(activity, "com.aliyun.svideo.editor.editor.EditorActivity")
                    intent.putParcelableArrayListExtra("mediaInfos", infoList)
                    intent.putExtra("draftBean",draftBean)
                    activity?.startActivity(intent)

                }
                R.id.iv_move->{
                    //移除除视频
                    deleteDialog?.show()
                    deleteDialog?.setOnConfirmListener(View.OnClickListener {
                        draftBean.delete()
                        mAdapter.remove(position)
                        list.remove(draftBean)
                        deleteDialog?.dismiss()
                        showToast("删除成功")
                        if (list.isEmpty()){
                            ll_empty_view.visibility=View.VISIBLE
                        }else{
                            ll_empty_view.visibility=View.GONE
                        }
                    })

                }
            }
        }
    }

    override fun lazyLoad() {
        list.clear()
        list=LitePal.findAll(DraftBean::class.java)
        list.reverse()
        for (item in list){
            com.orhanobut.logger.Logger.e("${item.thumbnailPath}")
        }
        mAdapter.setNewData(list)
        if (list.isEmpty()){
            ll_empty_view.visibility=View.VISIBLE
        }else{
            ll_empty_view.visibility=View.GONE
        }

    }

    private val mAdapter: DraftAdapter by lazy {
        DraftAdapter()
    }

    private fun initRv() {
        rv_draft.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = mAdapter
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
            isNestedScrollingEnabled = false
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun refreshList(event: RefreshDraftEvent){
        lazyLoad()
    }

}