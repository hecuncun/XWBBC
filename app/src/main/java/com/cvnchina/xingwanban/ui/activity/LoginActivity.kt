package com.cvnchina.xingwanban.ui.activity

import android.content.Intent
import android.graphics.Color
import android.view.View
import com.alibaba.fastjson.JSON
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.application.App
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.base.OtherLoginBean
import com.cvnchina.xingwanban.constants.Constant
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.net.CallbackListObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import com.cvnchina.xingwanban.utils.Preference
import com.mobile.auth.gatewayauth.AuthUIConfig
import com.mobile.auth.gatewayauth.PhoneNumberAuthHelper
import com.mobile.auth.gatewayauth.TokenResultListener
import com.mobile.auth.gatewayauth.model.TokenRet
import com.orhanobut.logger.Logger
import com.umeng.socialize.UMAuthListener
import com.umeng.socialize.UMShareAPI
import com.umeng.socialize.bean.SHARE_MEDIA
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by hecuncun on 2020/4/25
 */
class LoginActivity : BaseActivity() {
    private var lastLoginType: Int by Preference(Constant.LAST_TYPE, 0)
    override fun attachLayoutRes(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
       when(lastLoginType) {//1-QQ,2微信,3微博,4阿里一键登录
           1->{
               tv_last_qq.visibility=View.VISIBLE
               tv_last_wx.visibility=View.GONE
               tv_last_wb.visibility=View.GONE

           }
           2->{
               tv_last_qq.visibility=View.GONE
               tv_last_wx.visibility=View.VISIBLE
               tv_last_wb.visibility=View.GONE
           }
           3->{
               tv_last_qq.visibility=View.GONE
               tv_last_wx.visibility=View.GONE
               tv_last_wb.visibility=View.VISIBLE
           }
           4->{
               tv_last_qq.visibility=View.GONE
               tv_last_wx.visibility=View.GONE
               tv_last_wb.visibility=View.GONE
           }
           else->{
               tv_last_qq.visibility=View.GONE
               tv_last_wx.visibility=View.GONE
               tv_last_wb.visibility=View.GONE
           }

       }
    }

    override fun initView() {
        toolbar_title.text = "登录"
        toolbar_right_tv.text = "跳过"
        toolbar_right_tv.visibility = View.VISIBLE

        initOneKey()
    }

    private var tokenListener: TokenResultListener? = null
    private var mAlicomAuthHelper: PhoneNumberAuthHelper? = null
    private fun initOneKey() {
        tokenListener = object : TokenResultListener {
            override fun onTokenSuccess(p0: String?) {
                Logger.e("一键登录成功$p0")
                var tokenRet: TokenRet? = null
                try {
                    tokenRet = JSON.parseObject<TokenRet>(p0, TokenRet::class.java)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                if (tokenRet != null && "600001" != tokenRet.code) {//600001唤起授权页成功
                    type = 4
                    openId = tokenRet.token
                    mAlicomAuthHelper!!.quitLoginPage()
                    doLoginAction()
//                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
//                    finish()
                }
            }

            override fun onTokenFailed(p0: String?) {
                Logger.e("一键登录失败$p0")

            }
        }

        mAlicomAuthHelper = PhoneNumberAuthHelper.getInstance(App.context, tokenListener)

        mAlicomAuthHelper?.setAuthSDKInfo("pR5Qe8a9GOZy8h2GB0eglyRHIHQv+XKrc/0ChzuXT4MHXgnAZiNTzFam1QDur0TmsbQ7mbCrCvYCVbQtntSlZ9fjDgqbN6HNC6UOBMjW1S/Wg5FtcACCzMenXgrBCzFEJ4ynntHEsxCS/T40TUg/Apy2KyzUHjm/D27C75DJEZ0WSuAAowD2CaMWbU2+JGCO/RxrFKeZYN2iNaDzRvlsGDvvlRL39mwaLuAZIECQWEZkejOG5iWqJCg6q76ZKCg1Zft7TRe2CIj1fKmom8DtXpGiE2VKE3EdfAVCcq7U5MY=")
        mAlicomAuthHelper?.setLoggerEnable(true)
        mAlicomAuthHelper?.setAuthUIConfig(AuthUIConfig.Builder().setStatusBarColor(Color.parseColor("#026ED2")).create())
    }

    override fun initListener() {
        tv_one_key_login.setOnClickListener {
            //一键登录
            if (mAlicomAuthHelper!!.checkEnvAvailable()) {
                mAlicomAuthHelper!!.getLoginToken(this, 5000);
            } else {
                showToast("当前网络不支持，请检测蜂窝网络后重试")
            }
        }
        tv_other_login.setOnClickListener {
            startActivity(Intent(this, LoginOtherActivity::class.java))
            finish()
        }
        toolbar_right_tv.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
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
        iv_qq.setOnClickListener {
            //QQ登录
            UMShareAPI.get(this@LoginActivity)
                .getPlatformInfo(this@LoginActivity, SHARE_MEDIA.QQ, authListener)
        }
        iv_wb.setOnClickListener {
            //微博
            UMShareAPI.get(this@LoginActivity)
                .getPlatformInfo(this@LoginActivity, SHARE_MEDIA.SINA, authListener)
        }
        iv_wx.setOnClickListener {
            //微信
            UMShareAPI.get(this@LoginActivity)
                .getPlatformInfo(this@LoginActivity, SHARE_MEDIA.WEIXIN, authListener)
        }
    }

    private var openId: String? = null
    private var type = 0//1-QQ,2微信,3微博,4阿里一键登录
    /**
     * 第三方登录回调
     */
    internal var authListener: UMAuthListener = object : UMAuthListener {

        /**
         * 开始登录的回调
         * @param platform 第三方登录的平台名称
         */
        override fun onStart(platform: SHARE_MEDIA) {
            Logger.e("登录的第三方平台是:" + platform)
        }

        /**
         * 登录成功回调
         * @param platform
         * @param action
         * @param map
         */

        override fun onComplete(platform: SHARE_MEDIA, action: Int, map: Map<String, String>) {
            //  遍历map集合，取出QQ登录后回调给我们的信息
            for (key in map.keys) {
                Logger.e("key值是：" + key + "  对应的具体值:" + map[key] + "\n")
//              将取出的QQ账户信息存储到SharedPreferences中
                // ShareUtils.putString(this@LoginActivity, key, map[key])
            }
            when (platform) {
                SHARE_MEDIA.QQ -> {
                    type = 1
                    openId = map["openid"]
                }
                SHARE_MEDIA.WEIXIN -> {
                    type = 2
                    openId = map["openid"]
                }
                SHARE_MEDIA.SINA -> {
                    //todo openId
                    type = 3
                    openId = map["openid"]
                }
            }
            lastLoginType=type
            Logger.e("三方登录成功type==>$type<==openId==>$openId")
            //调用三方成功拿到openId
            doLoginAction()

        }

        /**
         * 失败
         * @param platform
         * @param action
         * @param t
         */
        override fun onError(platform: SHARE_MEDIA, action: Int, t: Throwable) {
            Logger.d("三方登录失败" + t.message)
        }

        /**
         * 取消登录的回调
         * @param platform
         * @param action
         */
        override fun onCancel(platform: SHARE_MEDIA, action: Int) {
            Logger.d("取消登录")
        }
    }

    /**
     * 调三方其他登录接口
     */
    private fun doLoginAction() {
        val otherLoginCall = SLMRetrofit.instance.api.otherLoginCall(type, openId)
        otherLoginCall.compose(ThreadSwitchTransformer())
            .subscribe(object : CallbackListObserver<OtherLoginBean>() {
                override fun onSucceed(t: OtherLoginBean) {

                    if (t.msg == "1") {
                        token = t.token
                        if (t.isBindPhone == 1) {//已绑定手机号  直接进入主页面
                            isLogin=true
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                            finish()
                        } else {//未绑定  跳绑定页
                            startActivity(Intent(this@LoginActivity, BindPhoneActivity::class.java))
                        }
                    } else {
                        showToast(t.msgCondition)
                    }
                }

                override fun onFailed() {

                }
            })
    }

    /**
     * QQ登录必须加入此回调
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data)
    }
}