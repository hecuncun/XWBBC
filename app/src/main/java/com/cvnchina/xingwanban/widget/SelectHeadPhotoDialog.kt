package com.cvnchina.xingwanban.widget

import android.content.Context
import android.support.design.widget.BottomSheetDialog
import android.view.LayoutInflater
import android.view.View
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.bean.DefaultHeadPhotoBean
import com.cvnchina.xingwanban.glide.GlideUtils
import kotlinx.android.synthetic.main.dialog_select_photo.*

/**
 * Created by hecuncun on 2020-5-2
 */
class SelectHeadPhotoDialog(context: Context) : BottomSheetDialog(context), View.OnClickListener {
    init {
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_select_photo, null)
        setContentView(view)
        delegate.findViewById<View>(android.support.design.R.id.design_bottom_sheet)?.setBackgroundColor(context.resources.getColor(android.R.color.transparent))
        iv_close.setOnClickListener(this)
        iv_def1.setOnClickListener(this)
        iv_def2.setOnClickListener(this)
        iv_def3.setOnClickListener(this)
        iv_def4.setOnClickListener(this)
        tv_album.setOnClickListener(this)
        tv_take_photo.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        mOnChoseListener?.select(v.id)
    }

    interface OnChoseListener {
        fun select(resId: Int)
    }

    private var mOnChoseListener: OnChoseListener? = null

    fun setOnChoseListener(onChoseListener: OnChoseListener) {
        mOnChoseListener = onChoseListener
    }

    fun setImageData(list: MutableList<DefaultHeadPhotoBean.DataBean>) {
        if (list.size>4){
            GlideUtils.showCircle(iv_def1,list[0].headPic,R.mipmap.head1)
            GlideUtils.showCircle(iv_def2,list[1].headPic,R.mipmap.head2)
            GlideUtils.showCircle(iv_def3,list[2].headPic,R.mipmap.head3)
            GlideUtils.showCircle(iv_def4,list[3].headPic,R.mipmap.head4)
        }

    }
}