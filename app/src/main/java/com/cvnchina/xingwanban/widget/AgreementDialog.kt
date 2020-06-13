package com.cvnchina.xingwanban.widget

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.application.App.Companion.context
import com.cvnchina.xingwanban.constants.Constant
import com.cvnchina.xingwanban.ui.activity.WebViewActivity
import com.cvnchina.xingwanban.utils.Preference
import com.flyco.dialog.utils.CornerUtils
import com.flyco.dialog.widget.base.BaseDialog
import kotlinx.android.synthetic.main.dialog_agreement.*


/**
 * Created by hecuncun on 2020-5-5
 */
class AgreementDialog(context: Context) : BaseDialog<AgreementDialog>(context) {
    private var isAgree: Boolean by Preference(Constant.IS_AGREE, false)
    override fun onCreateView(): View {
        widthScale(0.8f)
        // showAnim(Swing())
        // dismissAnim(this, new ZoomOutExit());
        val inflate = View.inflate(context, R.layout.dialog_agreement, null)
        inflate.setBackgroundDrawable(
            CornerUtils.cornerDrawable(
                Color.parseColor("#ffffff"),
                dp2px(10f).toFloat()
            )
        )
        return inflate
    }
    override fun setUiBeforShow() {

        tv_confirm.setOnClickListener{
            isAgree=true
            dismiss()
        }
        val str: SpannableString = SpannableString("请您务必审慎阅读、充分理解“用户协议”和“隐私协议”各条款，包括但不限于：为了向您提供视频拍摄和视频剪辑、内容分享等服务，我们需要收集您的设备信息、操作日志等信息。您可以在“设置”中查看、变更、删除个人信息并管理您的授权，您可阅读《用户协议》和《隐私协议》了解详细信息。如您同意，请点击“同意”开始接受我们的服务")
        str.setSpan(
            ForegroundColorSpan(context.resources.getColor(R.color.color_primary_yellow)),115,121,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)//（注意：包前不包后）
        str.setSpan(UserClick(context),115,121, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)//（注意：包前不包后）
        str.setSpan(
            ForegroundColorSpan(context.resources.getColor(R.color.color_primary_yellow)),122,128,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)//（注意：包前不包后）
        str.setSpan(PrivateClick(context),122,128, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tv_desc.text = str
        tv_desc.movementMethod= LinkMovementMethod.getInstance()//不设置 没有点击事件
        tv_desc.highlightColor=Color.TRANSPARENT//设置点击后的颜色为透明
    }

    fun setOnConfirmListener(listener: View.OnClickListener) {
        tv_cancel.setOnClickListener(listener)
    }


    class UserClick(context: Context) :ClickableSpan(){
        override fun onClick(widget: View) {
            //点击用户协议
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra("type",2)
            intent.flags = FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
        override fun updateDrawState(ds: TextPaint) {
            super.updateDrawState(ds)
            ds.color = context.resources.getColor(R.color.color_primary_yellow)
            ds.isUnderlineText = false
        }

    }

    class PrivateClick(context: Context) :ClickableSpan(){
        override fun onClick(widget: View) {
            //点击隐私
            val intent = Intent(context,WebViewActivity::class.java)
            intent.putExtra("type",3)
            intent.flags = FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }

        override fun updateDrawState(ds: TextPaint) {
            super.updateDrawState(ds)
            ds.color = context.resources.getColor(R.color.color_primary_yellow)
            ds.isUnderlineText = false
        }
    }
}