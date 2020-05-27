package com.cvnchina.xingwanban.widget

import android.content.Context
import android.graphics.Color
import android.view.View
import com.cvnchina.xingwanban.R
import com.flyco.dialog.utils.CornerUtils
import com.flyco.dialog.widget.base.BaseDialog
import kotlinx.android.synthetic.main.dialog_clear_cache.*

/**
 * Created by hecuncun on 2020-5-5
 */
class ClearCacheDialog(context: Context) : BaseDialog<ClearCacheDialog>(context) {

    override fun onCreateView(): View {
        widthScale(0.85f)
        // showAnim(Swing())
        // dismissAnim(this, new ZoomOutExit());
        val inflate =
            View.inflate(context, R.layout.dialog_clear_cache, null)
        inflate.setBackgroundDrawable(
            CornerUtils.cornerDrawable(
                Color.parseColor("#ffffff"),
                dp2px(12f).toFloat()
            )
        )
        return inflate
    }

    override fun setUiBeforShow() {
        tv_cancel.setOnClickListener { dismiss() }
    }

    fun setOnConfirmListener(listener: View.OnClickListener) {
        tv_comfirm.setOnClickListener(listener)
    }
}