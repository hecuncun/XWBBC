package com.cvnchina.xingwanban.ui.activity

import android.content.Intent
import android.util.TypedValue
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.bean.ScanLoginBean
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.net.CallbackListObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_scan_login.*

/**
 * Created by hecuncun on 2020-5-18
 */
class ScanLoginActivity : BaseActivity() {
    override fun attachLayoutRes(): Int = R.layout.activity_scan_login

    private var imei=""
    private var state=""//1 登录token不一致  2没token,没username
    private var locUrl=""
    private var locToken=""
    private var username=""

    override fun initData() {
        state = intent.getStringExtra("state")!!
        if (state!="3"){
            locUrl=intent.getStringExtra("locUrl")!!
        }
        if (state=="1"){

            locToken=intent.getStringExtra("locToken")!!
            username=intent.getStringExtra("username")!!
            imei = intent.getStringExtra("imei")!!
        }
        if (state=="1"){
            tv_state_title.text="您的手机端账号和电视端不一致，是否同步？"
            tv_state_title.setTextSize(TypedValue.COMPLEX_UNIT_SP,16f)
            tv_state.text="同步后，电视和手机可同屏互动"
            tv_state.setTextSize(TypedValue.COMPLEX_UNIT_SP,16f)
        }else{
            tv_state_title.text="星顽半登录确认"
            tv_state_title.setTextSize(TypedValue.COMPLEX_UNIT_SP,18f)
            tv_state.text="为保障账户安全，请确保是本人操作"
            tv_state.setTextSize(TypedValue.COMPLEX_UNIT_SP,18f)
        }
    }

    override fun initView() {
    }
private var tvToken=""
    override fun initListener() {
        tv_login.setOnClickListener {

            if (state=="3"){
                val scanLoginCall = SLMRetrofit.instance.api.scanLoginCall2(imei)
                scanLoginCall.compose(ThreadSwitchTransformer()).subscribe(object :CallbackListObserver<ScanLoginBean>(){
                    override fun onSucceed(t: ScanLoginBean) {
                       if (t.msg=="1"){
                           showToast("登录成功")
                           finish()
                       }
                    }

                    override fun onFailed() {

                    }
                })
            }else{
                val scanLoginCall = SLMRetrofit.instance.api.scanLoginCall(imei,1)
                scanLoginCall.compose(ThreadSwitchTransformer())
                    .subscribe(object : CallbackListObserver<ScanLoginBean>() {
                        override fun onSucceed(t: ScanLoginBean) {
                            if (t.msg == "1") {
                                showToast(t.msgCondition)
                                tvToken=t.tvToken
                                //替换后跳转H5
                                if (state=="1"){
                                    val url =locUrl.replace(username,token).replace(locToken,  t.tvToken)
                                    Logger.e("locUrl==$locUrl<===>新url==$url")
                                    val intent = Intent(this@ScanLoginActivity, WebViewActivity::class.java)
                                    intent.putExtra("type", 5)
                                    intent.putExtra("url", url)
                                    startActivity(intent)
                                    finish()
                                }else if(state=="3"){
                                    locUrl.split("?")[0]+"username=&$"

                                }else{
                                    val url =locUrl+"&token=${t.tvToken}&username=&$token"
                                    val intent = Intent(this@ScanLoginActivity, WebViewActivity::class.java)
                                    intent.putExtra("type", 5)
                                    intent.putExtra("url", url)
                                    startActivity(intent)
                                    finish()
                                }

                            }
                        }

                        override fun onFailed() {

                        }
                    })
            }

        }

        tv_finish.setOnClickListener {
            if (state=="3"){
                finish()
            }else{
                val scanLoginCall = SLMRetrofit.instance.api.scanLoginCall(imei,0)
                scanLoginCall.compose(ThreadSwitchTransformer())
                    .subscribe(object : CallbackListObserver<ScanLoginBean>() {
                        override fun onSucceed(t: ScanLoginBean) {
                            if (t.msg == "1") {
                                showToast(t.msgCondition)
                                tvToken=t.tvToken
                                //替换后跳转H5
                                if (state=="1"){
                                    val url =locUrl.replace(username,token).replace(locToken,  t.tvToken)
                                    Logger.e("locUrl==$locUrl<===>新url==$url")
                                    val intent = Intent(this@ScanLoginActivity, WebViewActivity::class.java)
                                    intent.putExtra("type", 5)
                                    intent.putExtra("url", url)
                                    startActivity(intent)
                                    finish()
                                }else{
                                    val url =locUrl+"&token=${t.tvToken}&username=&$token"
                                    val intent = Intent(this@ScanLoginActivity, WebViewActivity::class.java)
                                    intent.putExtra("type", 5)
                                    intent.putExtra("url", url)
                                    startActivity(intent)
                                    finish()
                                }

                            }
                        }

                        override fun onFailed() {

                        }
                    })
            }


//            if (state=="1"){
//                val intent = Intent(this@ScanLoginActivity, WebViewActivity::class.java)
//                intent.putExtra("type", 5)
//                intent.putExtra("url", locUrl)
//                startActivity(intent)
//                finish()
//            }else{
//                val scanLoginCall = SLMRetrofit.instance.api.scanLoginCall(imei,1)
//                scanLoginCall.compose(ThreadSwitchTransformer()).subscribe(object :CallbackListObserver<ScanLoginBean>(){
//                    override fun onSucceed(t: ScanLoginBean) {
//                        val url =locUrl+"&token=${t.tvToken}&username=&$token"
//                        val intent = Intent(this@ScanLoginActivity, WebViewActivity::class.java)
//                        intent.putExtra("type", 5)
//                        intent.putExtra("url", url)
//                        startActivity(intent)
//                        finish()
//                    }
//
//                    override fun onFailed() {
//
//                    }
//                })
//
//            }

        }
    }
}