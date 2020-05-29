package com.cvnchina.xingwanban.widget

import android.content.Context
import android.support.design.widget.BottomSheetDialog
import android.view.LayoutInflater
import android.view.View
import com.cvnchina.xingwanban.R
import kotlinx.android.synthetic.main.dialog_share_video.*

/**
 * Created by hecuncun on 2020-5-29
 */
class ShareDialog(context: Context,showDel:Boolean) : BottomSheetDialog(context), View.OnClickListener {
    init {
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_share_video, null)
        setContentView(view)
        delegate.findViewById<View>(android.support.design.R.id.design_bottom_sheet)
            ?.setBackgroundColor(context.resources.getColor(android.R.color.transparent))
        ll_qq.setOnClickListener(this)
        ll_qq_c.setOnClickListener(this)
        ll_wb.setOnClickListener(this)
        ll_wx.setOnClickListener(this)
        ll_wx_c.setOnClickListener(this)
        ll_del_video.setOnClickListener(this)

        ll_del_video.visibility=if (showDel) View.VISIBLE else View.GONE
    }


    interface OnChoseListener {
        fun select(resId: Int)
    }

    private var mOnChoseListener: OnChoseListener? = null

    fun setOnChoseListener(onChoseListener: OnChoseListener) {
        mOnChoseListener = onChoseListener
    }

    override fun onClick(v: View) {
        mOnChoseListener?.select(v.id)
    }
}