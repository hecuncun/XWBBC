package com.cvnchina.xingwanban.ui.activity

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.base.BaseNoDataBean
import com.cvnchina.xingwanban.bean.BindPhoneBean
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.net.CallbackListObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import com.cvnchina.xingwanban.utils.CountDownTimerUtils
import com.cvnchina.xingwanban.utils.RegexUtil
import kotlinx.android.synthetic.main.activity_login_other.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by hecuncun on 2020-5-17
 */
class BindPhoneActivity:BaseActivity() {
    private var countDownTimerUtils: CountDownTimerUtils? = null
    override fun attachLayoutRes(): Int= R.layout.activity_bind_phone

    override fun initData() {

    }

    override fun initView() {
        toolbar_title.text = "绑定手机号"
        countDownTimerUtils = CountDownTimerUtils(tv_get_code, 60000, 1000)//TextView计时器
    }

    override fun initListener() {
        tv_ruler.setOnClickListener {
            val intent = Intent(this,WebViewActivity::class.java)
            intent.putExtra("type",2)
            startActivity(intent)
        }
        tv_private.setOnClickListener {
            val intent = Intent(this,WebViewActivity::class.java)
            intent.putExtra("type",3)
            startActivity(intent)
        }
        tv_get_code.setOnClickListener {
            //获取手机验证码
            val phone = et_phone.text.toString().trim()
            if (!RegexUtil.checkMobile(phone)) {
                showToast("请输入正确的手机号")
                return@setOnClickListener
            }
            val observable = SLMRetrofit.instance.api.phoneCodeCall(phone)
            observable.compose(ThreadSwitchTransformer())
                .subscribe(object : CallbackListObserver<BaseNoDataBean>() {
                    override fun onSucceed(t: BaseNoDataBean) {
                        if (t.msg == "1") {
                            showToast(t.msgCondition)
                            //获取验证码
                            countDownTimerUtils?.start()
                        } else {
                            showToast(t.msgCondition)
                        }
                    }

                    override fun onFailed() {

                    }

                })

        }

        et_code.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv_confirm.isEnabled =
                    et_code.text.toString().trim().isNotEmpty() && et_phone.text.toString().trim().isNotEmpty()
            }
        })

        et_phone.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv_confirm.isEnabled =
                    et_code.text.toString().trim().isNotEmpty() && et_phone.text.toString().trim().isNotEmpty()
            }
        })

        tv_confirm.setOnClickListener { //绑定手机号
            val bindPhoneCall = SLMRetrofit.instance.api.bindPhoneCall(
                et_phone.text.toString().trim(),
                et_code.text.toString().trim()
            )
            bindPhoneCall.compose(ThreadSwitchTransformer()).subscribe(object :CallbackListObserver<BindPhoneBean>(){
                override fun onSucceed(t: BindPhoneBean) {
                   if (t.msg=="1"){
                       token=t.token
                       isLogin=true
                       startActivity(Intent(this@BindPhoneActivity,MainActivity::class.java))
                       finish()
                   }else{
                       showToast(t?.msgCondition)
                   }
                }

                override fun onFailed() {

                }
            })

        }
    }

}