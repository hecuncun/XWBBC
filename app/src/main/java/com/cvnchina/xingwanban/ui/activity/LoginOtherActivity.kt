package com.cvnchina.xingwanban.ui.activity

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.base.BaseNoDataBean
import com.cvnchina.xingwanban.bean.TokenBean
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.net.CallbackListObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import com.cvnchina.xingwanban.utils.CountDownTimerUtils
import com.cvnchina.xingwanban.utils.RegexUtil
import kotlinx.android.synthetic.main.activity_login_other.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by hecuncun on 2020/4/27
 */
class LoginOtherActivity : BaseActivity() {

    private var countDownTimerUtils: CountDownTimerUtils? = null
    override fun attachLayoutRes(): Int {
        return R.layout.activity_login_other
    }

    override fun initData() {

    }

    override fun initView() {
        toolbar_title.text = "登录"
       // toolbar_right_tv.visibility = View.VISIBLE
       // toolbar_right_tv.text = "随便看看"
       // toolbar_right_tv.setTextColor(resources.getColor(R.color.color_gray_999999))
        countDownTimerUtils = CountDownTimerUtils(tv_get_code, 60000, 1000)//TextView计时器
    }

    override fun initListener() {
//        toolbar_right_tv.setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))
//        }
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

        tv_confirm.setOnClickListener {
            //登录
            val observable = SLMRetrofit.instance.api.loginCall(
                et_phone.text.toString().trim(),
                 et_code.text.toString().trim()
            )
            observable.compose(ThreadSwitchTransformer())
                .subscribe(object : CallbackListObserver<TokenBean>() {
                    override fun onSucceed(t: TokenBean) {
                        showToast(t.msgCondition)
                        if (t.msg == "1") {//保存token
                            token = t.token
                            isLogin=true
                            startActivity(Intent(this@LoginOtherActivity,MainActivity::class.java))
                            //关闭登录页
                            finish()
                        }else{
                            showToast(t.msgCondition)
                        }


                    }

                    override fun onFailed() {

                    }

                })
        }
    }
}