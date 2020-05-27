package com.cvnchina.xingwanban.widget

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.cvnchina.xingwanban.R
import kotlinx.android.synthetic.main.dialog_progress.*

/**
 * Created by hecuncun on 2020-5-15
 */
class ProgressDialog(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_progress)
        setCanceledOnTouchOutside(false)
        window.setBackgroundDrawable(ColorDrawable(context.resources.getColor(R.color.color_gray_transparent)))
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

    fun setText(text:String){
        tv_desc.text=text
    }

    fun setProgress(progress:Int){
        progress_bar.setProgress(progress)
        if (progress==100){
            iv_finish.visibility= View.VISIBLE
            progress_bar.visibility=View.GONE
        }else{
            progress_bar.visibility=View.VISIBLE
            iv_finish.visibility= View.GONE
        }
    }

}