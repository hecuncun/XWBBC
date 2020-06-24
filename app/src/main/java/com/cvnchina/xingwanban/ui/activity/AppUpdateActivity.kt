package com.cvnchina.xingwanban.ui.activity

import android.view.View
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.bean.UpdateAppBean
import com.cvnchina.xingwanban.utils.PackageUtils
import kotlinx.android.synthetic.main.activity_app_update.*
import kotlinx.android.synthetic.main.toolbar.*
import update.UpdateAppUtils

/**
 * Created by hecuncun on 2020-5-5
 */
class AppUpdateActivity:BaseActivity() {
    private var canUpdate=false
    override fun attachLayoutRes(): Int {
        return R.layout.activity_app_update
    }
    private var bean:UpdateAppBean?=null

    override fun initData() {
        bean = intent.getParcelableExtra<UpdateAppBean>("updateAppBean")
        if (bean!=null){
            tv_desc.text=bean!!.updateDesc
           // tv_app_version.text=bean!!.appVersion
            tv_app_version.text=PackageUtils.getVersionName(this)
            if (PackageUtils.getVersionName(this)!=bean!!.appVersion){
                canUpdate=true
                tv_notify.text="星顽半视频有新版本${bean!!.appVersion}更新啦！"
            }else{
                tv_notify.text=""
            }


        }
       if (canUpdate) {
           tv_update.visibility= View.VISIBLE
       }else{
           tv_update.visibility= View.GONE
       }
    }

    override fun initView() {
      toolbar_title.text="版本更新"
    }

    override fun initListener() {

        tv_update.setOnClickListener {
            //开始下载更新
            UpdateAppUtils
                .getInstance()
                .apkUrl(bean!!.downloadUrl?:"")
                .updateContent(bean!!.updateDesc)
                .update()
        }
    }
}