package com.cvnchina.xingwanban.widget

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.ViewGroup
import com.aliyun.svideo.editor.EditorMediaActivity
import com.aliyun.svideo.editor.bean.AlivcEditInputParam
import com.aliyun.svideo.recorder.activity.AlivcSvideoRecordActivity
import com.aliyun.svideo.recorder.bean.AlivcRecordInputParam
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.constants.Constant
import com.cvnchina.xingwanban.ui.activity.LoginActivity
import com.cvnchina.xingwanban.utils.Preference
import kotlinx.android.synthetic.main.dialog_full_screen.*


/**
 * Created by heCunCun on 2020/4/29
 */
class FullScreenDialog(context: Context) : Dialog(context) {
    /**
     * check login
     */
    private var isLogin: Boolean by Preference(Constant.LOGIN_KEY, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_full_screen)
        setCanceledOnTouchOutside(false)
        window.setBackgroundDrawable(ColorDrawable(context.resources.getColor(R.color.color_gray_transparent)))
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        setListener()
    }

    private fun setListener() {
        iv_cancel.setOnClickListener {
            dismiss()
        }
        ll_edit.setOnClickListener {
            //进入编辑页
            if (isLogin) {
                val param = AlivcEditInputParam.Builder()
                    .build()
                EditorMediaActivity.startImport(context, param,-1)

            } else {
                context.startActivity(Intent(context, LoginActivity::class.java))
            }
            dismiss()
        }
        ll_camera.setOnClickListener {
            //进入录制页面
            if (isLogin) {
                startRecord(context)
            } else {
                context.startActivity(Intent(context, LoginActivity::class.java))
            }
            dismiss()
        }
    }

    private fun startRecord(context: Context) {
        val recordParam = AlivcRecordInputParam.Builder()
            .build()
        AlivcSvideoRecordActivity.startRecord(context, recordParam)
    }

}