package com.cvnchina.xingwanban.ui.activity

import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.os.Environment
import android.support.v4.app.FragmentTransaction
import android.view.Gravity
import android.view.KeyEvent
import android.view.View
import android.view.WindowManager
import cn.jzvd.JzvdStd
import cn.qqtheme.framework.picker.WheelPicker
import com.aliyun.svideo.common.base.BaseDialogFragment.getScreenWidth
import com.aliyun.svideo.common.utils.ScreenUtils
import com.blankj.utilcode.util.ScreenUtils.getScreenWidth
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.application.App
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.bean.UpdateAppBean
import com.cvnchina.xingwanban.event.ChangeEvent
import com.cvnchina.xingwanban.event.LogoutEvent
import com.cvnchina.xingwanban.ext.showToast
import com.cvnchina.xingwanban.net.CallbackObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import com.cvnchina.xingwanban.ui.fragment.HomeFragment
import com.cvnchina.xingwanban.ui.fragment.MineFragment
import com.cvnchina.xingwanban.utils.PackageUtils
import com.cvnchina.xingwanban.widget.AgreementDialog
import com.cvnchina.xingwanban.widget.FullScreenDialog
import com.luck.picture.lib.tools.ScreenUtils.getScreenWidth
import com.orhanobut.logger.Logger
import com.umeng.socialize.view.BaseDialog
import kotlinx.android.synthetic.main.activity_main.*
import listener.UpdateDownloadListener
import model.UpdateConfig
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import update.UpdateAppUtils

class MainActivity : BaseActivity(), View.OnClickListener {
    private var homeFragment: HomeFragment? = null
    private var mineFragment: MineFragment? = null
    private var dialog: FullScreenDialog? = null
    override fun useEventBus(): Boolean = true

    private var agreementDialog:AgreementDialog?=null
    override fun attachLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        Logger.e("MainActivity启动")
        if (checkPermissions(
                arrayOf(
                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.CAMERA,
                    android.Manifest.permission.RECORD_AUDIO
                )
            )
        ) {

        } else {
            requestPermission(
                arrayOf(
                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.CAMERA,
                    android.Manifest.permission.RECORD_AUDIO
                ), 0x333
            )
        }

        //获取启动页图片
        val updateAppCall = SLMRetrofit.instance.api.updateAppCall()
        updateAppCall.compose(ThreadSwitchTransformer()).subscribe(object :
            CallbackObserver<UpdateAppBean>(){
            override fun onSucceed(updateAppBean: UpdateAppBean?, desc: String?) {
                if (updateAppBean!=null){
                    if (PackageUtils.getVersionName(this@MainActivity)!=updateAppBean.appVersion){
                        // 更新配置

                        val updateConfig = UpdateConfig().apply {
                            force = updateAppBean.isForcedUpdate=="1"
                            checkWifi = true
                            needCheckMd5 = false
                            isShowNotification = true
                            notifyImgRes = R.mipmap.logo
                            apkSavePath = Environment.getExternalStorageDirectory().absolutePath +"/xwb"
                            apkSaveName = "xwb"
                        }

                        UpdateAppUtils
                            .getInstance()
                            .apkUrl(updateAppBean.downloadUrl?:"")
                            .updateTitle("")
                            .updateContent(updateAppBean.updateDesc)
                            .updateConfig(updateConfig)
                            //.uiConfig(uiConfig)
                            .setUpdateDownloadListener(object : UpdateDownloadListener {
                                override fun onDownload(progress: Int) {

                                }

                                override fun onError(e: Throwable) {

                                }

                                override fun onFinish() {

                                }

                                override fun onStart() {

                                }
                                // do something
                            })
                            .update()
                    }
                }
            }

            override fun onFailed() {

            }
        })


    }

    override fun initView() {
        dialog = FullScreenDialog(this)
        agreementDialog= AgreementDialog(this)
        agreementDialog?.setCanceledOnTouchOutside(false)
        agreementDialog?.setCancelable(false)
        if (!isAgree){//还未同意

            agreementDialog?.show()
            //todo 适配今日头条弹窗不居中解决
            val lp= agreementDialog!!.window.attributes;
//设置宽高，高度默认是自适应的，宽度根据屏幕宽度比例设置
            lp.width = ScreenUtils.getWidth(this);
//这里设置居中
            lp.gravity = Gravity.CENTER;
            agreementDialog?.window?.attributes = lp
            agreementDialog?.setOnConfirmListener(View.OnClickListener {
                //不同意
                agreementDialog?.dismiss()
                finish()
            })
        }

    }


    override fun initListener() {
        tv_home.setOnClickListener(this)
        tv_mine.setOnClickListener(this)
        tv_home.performClick()

        iv_publish.setOnClickListener {
            dialog?.show()
        }
    }

    override fun onClick(v: View) {
        val transaction = supportFragmentManager.beginTransaction()
        hideAllFragment(transaction)
        when (v.id) {
            R.id.tv_home -> {
                tv_home.setTextColor(resources.getColor(R.color.color_gray_F9F9F9))
                tv_mine.setTextColor(resources.getColor(R.color.color_gray_999999))
                if (homeFragment == null) {
                    homeFragment = HomeFragment.getInstance()
                    transaction.add(R.id.fragment_container, homeFragment!!)
                }
                transaction.show(homeFragment!!)
            }
            R.id.tv_mine -> {
                if (!isLogin){
                    startActivity(Intent(this, LoginActivity::class.java))
                    return
                }
                tv_mine.setTextColor(resources.getColor(R.color.color_gray_F9F9F9))
                tv_home.setTextColor(resources.getColor(R.color.color_gray_999999))
                if (mineFragment == null) {
                    mineFragment = MineFragment.getInstance()
                    transaction.add(R.id.fragment_container, mineFragment!!)
                }
                transaction.show(mineFragment!!)
            }
        }
        //transaction.commit()
        transaction.commitAllowingStateLoss()
    }

    private fun hideAllFragment(transaction: FragmentTransaction) {
        homeFragment?.let {
            transaction.hide(it)
        }
        mineFragment?.let {
            transaction.hide(it)
        }

    }

    private var mExitTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis().minus(mExitTime) <= 2000) {
                finish()
            } else {
                mExitTime = System.currentTimeMillis()
                showToast("再按一次退出程序")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun logout(event: LogoutEvent) {
        Logger.e("销毁主页")
        finish()
    }
    override fun onBackPressed() {
        if (JzvdStd.backPress()) {
            return
        }
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        JzvdStd.goOnPlayOnPause()
    }

    override fun onResume() {
        super.onResume()
        JzvdStd.goOnPlayOnResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.e("MainActivity销毁")
        JzvdStd.releaseAllVideos()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun refreshHome(event: ChangeEvent){
        tv_home.performClick()
        Logger.e("切换到首页  ")
    }

}
