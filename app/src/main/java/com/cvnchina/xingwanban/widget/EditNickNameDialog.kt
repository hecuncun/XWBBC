package com.cvnchina.xingwanban.widget

import android.content.Context
import android.support.design.widget.BottomSheetDialog
import android.view.LayoutInflater
import android.view.View
import com.cvnchina.xingwanban.R
import kotlinx.android.synthetic.main.dialog_edit_nick_name.*

/**
 * Created by hecuncun on 2020-5-2
 */
class EditNickNameDialog(context: Context):BottomSheetDialog(context), View.OnClickListener {
    init {
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_edit_nick_name, null)
        setContentView(view)
        delegate.findViewById<View>(android.support.design.R.id.design_bottom_sheet)?.setBackgroundColor(context.resources.getColor(android.R.color.transparent))
        iv_close.setOnClickListener(this)
        tv_confirm.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        mOnChoseListener?.select(v.id,editText.textString)
    }

    interface OnChoseListener {
        fun select(resId: Int,str:String)
    }

    private var mOnChoseListener: OnChoseListener? = null

    fun setOnChoseListener(onChoseListener: OnChoseListener) {
        mOnChoseListener = onChoseListener
    }

}