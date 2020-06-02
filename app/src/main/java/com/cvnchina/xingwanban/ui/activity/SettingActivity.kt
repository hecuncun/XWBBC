package com.cvnchina.xingwanban.ui.activity


import android.content.Intent
import android.os.Environment
import android.view.View
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.bean.UpdateAppBean
import com.cvnchina.xingwanban.event.LogoutEvent
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.net.CallbackObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import com.cvnchina.xingwanban.utils.FileSizeUtil
import com.cvnchina.xingwanban.utils.FileUtils
import com.cvnchina.xingwanban.utils.PackageUtils
import com.cvnchina.xingwanban.widget.ClearCacheDialog
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.toolbar.*
import org.greenrobot.eventbus.EventBus

/**
 * Created by hecuncun on 2020-5-5
 */
class SettingActivity : BaseActivity() {
    private var clearCacheDialog:ClearCacheDialog?=null

    override fun attachLayoutRes(): Int {
        return R.layout.activity_setting
    }

    override fun initData() {
        clearCacheDialog= ClearCacheDialog(this)
        getUpdateInfo()
    }
private var updateAppBean:UpdateAppBean?=null
    private fun getUpdateInfo() {
        //获取启动页图片
        val updateAppCall = SLMRetrofit.instance.api.updateAppCall()
        updateAppCall.compose(ThreadSwitchTransformer()).subscribe(object :
            CallbackObserver<UpdateAppBean>(){
            override fun onSucceed(t: UpdateAppBean?, desc: String?) {
                if (t!=null){
                    updateAppBean=t
                    tv_version.text=t.appVersion
                    val versionCode = PackageUtils.getVersionCode(this@SettingActivity)
                    if (t.appVersion.toInt()>versionCode){
                        tv_dot.visibility=View.VISIBLE
                    }else{
                        tv_dot.visibility=View.GONE
                    }
                }


            }

            override fun onFailed() {

            }
        })
    }

    override fun initView() {
        toolbar_title.text = "设置"
        tv_cache_size.text=FileSizeUtil.getAutoFileOrFilesSize(Environment.getExternalStorageDirectory().toString() + "/record/")
    }

    override fun initListener() {
        rl_clear_cache.setOnClickListener { //清除缓存
            clearCacheDialog?.show()
            clearCacheDialog?.setOnConfirmListener(View.OnClickListener {
                showToast("缓存已清理完毕")
                tv_cache_size.text="0KB"
                FileUtils.deleteDirectory(Environment.getExternalStorageDirectory().toString() + "/record/")
                clearCacheDialog!!.dismiss()
            })
        }

        rl_app_update.setOnClickListener { //app检查更新
            val intent =Intent(this,AppUpdateActivity::class.java)
            intent.putExtra("updateAppBean",updateAppBean)
            startActivity(intent)
        }

        rl_feedback.setOnClickListener {
            val intent =Intent(this,FeedBackActivity::class.java)
            startActivity(intent)
        }
        rl_logout.setOnClickListener { //退出登录
            isLogin=false
            token=""
            startActivity(Intent(this@SettingActivity,LoginActivity::class.java))
            EventBus.getDefault().post(LogoutEvent())
            finish()
        }

        rl_common_problem.setOnClickListener {
            val intent =Intent(this,CommonProblemActivity::class.java)
            startActivity(intent)
        }

    }
}