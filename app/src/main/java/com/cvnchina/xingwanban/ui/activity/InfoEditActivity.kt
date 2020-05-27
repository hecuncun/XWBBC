package com.cvnchina.xingwanban.ui.activity

import android.view.View
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.bean.PersonalInfoBean
import com.cvnchina.xingwanban.event.RefreshPersonalInfoEvent
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.net.CallbackObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import kotlinx.android.synthetic.main.activity_edit_info.*
import kotlinx.android.synthetic.main.toolbar.*
import org.greenrobot.eventbus.EventBus

/**
 * Created by hecuncun on 2020-5-3
 */
class InfoEditActivity : BaseActivity() {
    private var sexCode = 1
    private var map= mutableMapOf<String,String>()
    override fun attachLayoutRes(): Int {
        return R.layout.activity_edit_info
    }

    override fun initData() {
        val personalInfoBean = intent.getParcelableExtra<PersonalInfoBean>("personalInfoBean")
        if (personalInfoBean!=null){
            sexCode=if ( (personalInfoBean.sex == "男")) 1 else 2
            et_desc.setHint(personalInfoBean.signature)
        }

    }

    override fun initView() {
        toolbar_title.text = "个人说明"
        toolbar_right_tv.text = "保存"
        toolbar_right_tv.setTextColor(resources.getColor(R.color.color_primary_yellow))
        toolbar_right_tv.visibility = View.VISIBLE
    }

    override fun initListener() {
        toolbar_right_tv.setOnClickListener {
            //保存修改
            map["signature"]= et_desc.textString
            val editPersonalInfoCall = SLMRetrofit.instance.api.editPersonalInfoCall(map,sexCode)
            editPersonalInfoCall.compose(ThreadSwitchTransformer()).subscribe(object :
                CallbackObserver<PersonalInfoBean>(){
                override fun onSucceed(t: PersonalInfoBean?, desc: String?) {
                    EventBus.getDefault().post(RefreshPersonalInfoEvent())
                    showToast("保存成功")
                    finish()
                }

                override fun onFailed() {

                }
            })
        }
    }
}