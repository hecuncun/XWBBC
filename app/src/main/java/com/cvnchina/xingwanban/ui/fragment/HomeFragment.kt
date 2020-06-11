package com.cvnchina.xingwanban.ui.fragment

import android.Manifest
import android.content.Intent
import android.support.v4.app.FragmentTransaction
import android.view.View
import com.aliyun.svideo.editor.EditorMediaActivity
import com.aliyun.svideo.editor.bean.AlivcEditInputParam
import com.aliyun.svideo.recorder.activity.AlivcSvideoRecordActivity
import com.aliyun.svideo.recorder.bean.AlivcRecordInputParam
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.bean.MsgCountBean
import com.cvnchina.xingwanban.bean.PersonalInfoBean
import com.cvnchina.xingwanban.event.LogoutEvent
import com.cvnchina.xingwanban.event.RefreshDraftEvent
import com.cvnchina.xingwanban.event.RefreshWorksEvent
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.net.CallbackListObserver
import com.cvnchina.xingwanban.net.CallbackObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import com.cvnchina.xingwanban.ui.activity.*
import com.lhzw.bluetooth.base.BaseFragment
import com.orhanobut.logger.Logger
//import com.uuzuche.lib_zxing.activity.CaptureActivity
//import com.uuzuche.lib_zxing.activity.CodeUtils
import kotlinx.android.synthetic.main.fragment_home.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Created by heCunCun on 2020/4/29
 */
class HomeFragment : BaseFragment(), View.OnClickListener {
    override fun useEventBus(): Boolean=true
    private val REQUEST_CODE = 0x333
    private val PERMISS_REQUEST_CODE = 0x356

    private var worksFragment: WorksFragment? = null
    private var draftFragment: DraftFragment? = null

    companion object {
        fun getInstance(): HomeFragment = HomeFragment()
    }

    override fun attachLayoutRes(): Int {
        return R.layout.fragment_home
    }

    override fun initView(view: View) {
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onRefreshWorks(event:RefreshWorksEvent){
        Logger.e("发布  切换到发布")
        rl_works.performClick()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onRefreshDraft(event:RefreshDraftEvent){
        Logger.e("草稿  切换到草稿")
        rl_draft.performClick()
    }

    override fun initListener() {
        rl_works.setOnClickListener(this)
        rl_draft.setOnClickListener(this)
        rl_works.performClick()
        tv_msg.setOnClickListener {
            if (isLogin) {
                startActivity(Intent(activity, MsgActivity::class.java))
                tv_msg.visibility=View.GONE
            } else {
                startActivity(Intent(activity, LoginActivity::class.java))
                (activity!!as MainActivity).finish()
            }

        }

        ll_edit.setOnClickListener {
            if (isLogin) {
                val param = AlivcEditInputParam.Builder()
                    .build()
                EditorMediaActivity.startImport(context, param,-1)
            } else {
                startActivity(Intent(activity, LoginActivity::class.java))
                (activity!!as MainActivity).finish()
            }

        }
        ll_take.setOnClickListener {
            if (isLogin) {
                val recordParam = AlivcRecordInputParam.Builder()
                    .build()
                AlivcSvideoRecordActivity.startRecord(context, recordParam)
            } else {
                startActivity(Intent(activity, LoginActivity::class.java))
                (activity!!as MainActivity).finish()
            }

        }
        ll_scan.setOnClickListener {
            //二维码扫描
            if (isLogin) {
                jumpToScannerActivity2()
            } else {
                startActivity(Intent(activity, LoginActivity::class.java))
                (activity!!as MainActivity).finish()
            }
        }


        initTypeListener()

    }

    private fun initTypeListener() {
        tv_0.setOnClickListener {
            if (isLogin) {
                val param = AlivcEditInputParam.Builder()
                    .build()
                EditorMediaActivity.startImport(context, param,0)
            } else {
                startActivity(Intent(activity, LoginActivity::class.java))
                (activity!!as MainActivity).finish()
            }
        }
        tv_1.setOnClickListener {
            if (isLogin) {
                val param = AlivcEditInputParam.Builder()
                    .build()
                EditorMediaActivity.startImport(context, param,1)
            } else {
                startActivity(Intent(activity, LoginActivity::class.java))
                (activity!!as MainActivity).finish()
            }
        }
        tv_2.setOnClickListener {
            if (isLogin) {
                val param = AlivcEditInputParam.Builder()
                    .build()
                EditorMediaActivity.startImport(context, param,2)
            } else {
                startActivity(Intent(activity, LoginActivity::class.java))
                (activity!!as MainActivity).finish()
            }
        }
        tv_3.setOnClickListener {
            if (isLogin) {
                val param = AlivcEditInputParam.Builder()
                    .build()
                EditorMediaActivity.startImport(context, param,3)
            } else {
                startActivity(Intent(activity, LoginActivity::class.java))
                (activity!!as MainActivity).finish()
            }
        }
        tv_4.setOnClickListener {
            if (isLogin) {
                val param = AlivcEditInputParam.Builder()
                    .build()
                EditorMediaActivity.startImport(context, param,4)
            } else {
                startActivity(Intent(activity, LoginActivity::class.java))
                (activity!!as MainActivity).finish()
            }
        }
        tv_5.setOnClickListener {
            if (isLogin) {
                val param = AlivcEditInputParam.Builder()
                    .build()
                EditorMediaActivity.startImport(context, param,5)
            } else {
                startActivity(Intent(activity, LoginActivity::class.java))
                (activity!!as MainActivity).finish()
            }
        }
        tv_6.setOnClickListener {
            if (isLogin) {
                val param = AlivcEditInputParam.Builder()
                    .build()
                EditorMediaActivity.startImport(context, param,6)
            } else {
                startActivity(Intent(activity, LoginActivity::class.java))
                (activity!!as MainActivity).finish()
            }
        }
        tv_9.setOnClickListener {
            val param = AlivcEditInputParam.Builder()
                .build()
            EditorMediaActivity.startImport(context, param,9)


//            if (isLogin) {
//                val param = AlivcEditInputParam.Builder()
//                    .build()
//                EditorMediaActivity.startImport(context, param,9)
//            } else {
//                startActivity(Intent(activity, LoginActivity::class.java))
//                (activity!!as MainActivity).finish()
//            }
        }
    }

    private fun initPersonalInfo() {
        //请求个人信息
        val personalInfoCall = SLMRetrofit.instance.api.personalInfoCall()
        personalInfoCall.compose(ThreadSwitchTransformer()).subscribe(object :
            CallbackObserver<PersonalInfoBean>() {
            override fun onSucceed(t: PersonalInfoBean, desc: String) {
                //初始化个人信息
                nickname = t.nickName
            }

            override fun onFailed() {
            }
        })
    }
//    private fun jumpToScannerActivity() {// Manifest.permission.VIBRATE允许访问振动设备
//        if (checkPermissions(arrayOf(Manifest.permission.CAMERA, Manifest.permission.VIBRATE))) {
//            val intent = Intent(activity, CaptureActivity::class.java)
//            startActivityForResult(intent, REQUEST_CODE)
//        } else {
//            requestPermission(
//                arrayOf(Manifest.permission.CAMERA, Manifest.permission.VIBRATE),
//                PERMISS_REQUEST_CODE
//            )
//        }
//
//    }

    private fun jumpToScannerActivity2() {// Manifest.permission.VIBRATE允许访问振动设备
        if (checkPermissions(arrayOf(Manifest.permission.CAMERA, Manifest.permission.VIBRATE))) {
            val intent = Intent(activity, ScanQRCodeActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        } else {
            requestPermission(
                arrayOf(Manifest.permission.CAMERA, Manifest.permission.VIBRATE),
                PERMISS_REQUEST_CODE
            )
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISS_REQUEST_CODE) {
            val intent = Intent(activity, ScanQRCodeActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun lazyLoad() {
        //获取未读消息数
        if (isLogin) {
            val msgCountCall = SLMRetrofit.instance.api.msgCountCall()
            msgCountCall.compose(ThreadSwitchTransformer())
                .subscribe(object : CallbackListObserver<MsgCountBean>() {
                    override fun onSucceed(t: MsgCountBean) {
                        if (t.msg == "1") {
                            if (t.count == 0) {
                                tv_msg.visibility = View.GONE
                            } else tv_msg.visibility = View.VISIBLE
                            tv_msg.text = "您有${t.count}条新消息"
                        } else if (t.msg=="-100"){//token过期
                            isLogin=false
                            token=""
                            startActivity(Intent(activity,LoginActivity::class.java))
                            EventBus.getDefault().post(LogoutEvent())
                        }else{
                            showToast(t.msgCondition)
                        }

                    }

                    override fun onFailed() {

                    }
                })

            initPersonalInfo()
        }

    }

    override fun onClick(v: View) {
        val transaction = activity!!.supportFragmentManager.beginTransaction()
        hideAllFragment(transaction)
        when (v.id) {
            R.id.rl_works -> {
                tv_works.setTextColor(resources.getColor(R.color.color_gray_F9F9F9))
                tv_draft.setTextColor(resources.getColor(R.color.color_gray_999999))
                iv_works.visibility = View.VISIBLE
                iv_draft.visibility = View.INVISIBLE

                if (worksFragment == null) {
                    worksFragment = WorksFragment.getInstance()
                    transaction.add(R.id.rl_container, worksFragment!!)
                }
                transaction.show(worksFragment!!)
            }
            R.id.rl_draft -> {
                if (!isLogin) {
                    startActivity(Intent(activity, LoginActivity::class.java))
                    (activity!!as MainActivity).finish()
                    return
                }
                tv_draft.setTextColor(resources.getColor(R.color.color_gray_F9F9F9))
                tv_works.setTextColor(resources.getColor(R.color.color_gray_999999))
                iv_works.visibility = View.INVISIBLE
                iv_draft.visibility = View.VISIBLE
                if (draftFragment == null) {
                    draftFragment = DraftFragment.getInstance()
                    transaction.add(R.id.rl_container, draftFragment!!)
                }
                transaction.show(draftFragment!!)
            }
        }
       // transaction.commit()
        transaction.commitAllowingStateLoss()
    }

    private fun hideAllFragment(transaction: FragmentTransaction) {
        draftFragment?.let {
            transaction.hide(it)
        }
        worksFragment?.let {
            transaction.hide(it)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            //扫描结果
            if (data != null) {
                val result=data.getStringExtra("result")
                        Logger.e("二维码==$result")
                        if (result != null && result.contains("&doType=")) {
//                            result =
//                                "http://10.1.17.75:8055/comment?username=13810817985&token=02SGY7BApBRCs5AVsIEXV6VEgQH2Y@DBRXEX56UEELBHJ8VE0FBnV6SVtcXCooAFsIESUqV05RUiYpXBgCAHB4ARsKAiAvUBxUVyFyBEgAUHVyR1UQRjcuFxdTXiFpX1sDAHx6VUEDBH1zUFtP&imei=1820e9306332d5211bef5fb7e84a81c4&video_id=215976&doType=comment"
                            val str1 = result.substring(0, result.indexOf("&doType="))
                            val type = result.substring(str1.length + 8, result.length)
                            Logger.e("type=$type")
                            when (type) {
                                "comment" -> {//H5页面
                                    if (str1.contains("username=")) {//有userName 字段
                                        val username = str1.substring(
                                            str1.indexOf("username=") + 9,
                                            str1.indexOf("&token")
                                        )
                                        val locToken = str1.substring(
                                            str1.indexOf("&token=") + 7,
                                            str1.indexOf("&imei=")
                                        )

                                        Logger.e("username==$username")
                                        if (username.isEmpty()&&locToken.isEmpty()){//userName为空
                                            val locUrl =
                                                str1.replace("username=&token=&", "")
                                            val imei = result.substring(
                                                result.indexOf("&imei=") + 6,
                                                result.indexOf("&video_id=")
                                            )
                                            val intent = Intent(activity, ScanLoginActivity::class.java)
                                            intent.putExtra("state", "2")
                                            intent.putExtra("locUrl", locUrl)
                                            intent.putExtra("imei",imei)
                                            startActivity(intent)
                                            return

                                        }

                                        if (username == token) {//用户相同  跳H5
                                            val url = str1+"&platForm=app"
                                            val intent =
                                                Intent(activity, WebViewActivity::class.java)
                                            intent.putExtra("type", 5)
                                            intent.putExtra("url", url)
                                            startActivity(intent)
                                        } else {//不同  跳是否同步登陆
                                            val imei = result.substring(
                                                result.indexOf("&imei=") + 6,
                                                result.indexOf("&video_id=")
                                            )
                                            val intent =
                                                Intent(activity, ScanLoginActivity::class.java)
                                            intent.putExtra("state", "1")
                                            intent.putExtra("imei", imei)
                                            intent.putExtra("locUrl", str1)
                                            intent.putExtra("locToken", locToken)
                                            intent.putExtra("username", username)
                                            startActivity(intent)
                                        }
                                    } else {//没有userName字段
                                        val imei = result.substring(
                                            result.indexOf("&imei=") + 6,
                                            result.indexOf("&video_id=")
                                        )
                                        val intent = Intent(activity, ScanLoginActivity::class.java)
                                        intent.putExtra("state", "2")
                                        intent.putExtra("locUrl", str1)
                                        intent.putExtra("imei",imei)
                                        startActivity(intent)
                                    }
//                                    val imei=result.substring(result.indexOf("&imei=")+6,result.indexOf("&video_id="))
//                                    val intent =Intent(activity, WebViewActivity::class.java)
//                                    intent.putExtra("type",5)
//                                    intent.putExtra("url",url)
//                                    startActivity(intent)
                                }
                                "login" -> {
                                    //http://10.1.17.75:8055/comment?username=&token=&imei=1820e9306332d5211bef5fb7e84a81c4&doType=login
                                    //扫描成功进入扫码登录页
                                        val imei=result.substring(result.indexOf("&imei=")+6,result.indexOf("&doType=login"))
                                        val intent = Intent(activity, ScanLoginActivity::class.java)
                                        intent.putExtra("state", "3")
                                        intent.putExtra("imei", imei)
                                        startActivity(intent)


                                }
                                "upload" -> {
                                    if (isLogin) {
                                        val param = AlivcEditInputParam.Builder()
                                            .build()
                                        EditorMediaActivity.startImport(context, param,-1)
                                    } else {
                                        startActivity(Intent(activity, LoginActivity::class.java))
                                        (activity!!as MainActivity).finish()
                                    }
                                }
                                else -> {
                                    showToast("不是目标二维码$result")
                                }
                            }
                        } else {
                            showToast("目标二维码错误$result")
                        }


                    } else {
                        //showToast("扫描失败")
                    }


        }
    }
}