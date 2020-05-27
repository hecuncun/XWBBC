package com.cvnchina.xingwanban.application

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import android.util.Log
import com.aliyun.common.httpfinal.QupaiHttpFinal
import com.aliyun.svideo.downloader.DownloaderManager
import com.cvnchina.xingwanban.BuildConfig
import com.cvnchina.xingwanban.utils.LogCatStrategy
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.simple.spiderman.SpiderMan
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import com.umeng.commonsdk.UMConfigure
import com.umeng.socialize.PlatformConfig

import org.litepal.LitePal
import update.UpdateAppUtils
import kotlin.properties.Delegates

/**
 * Created by hecuncun on 2019/12/2
 */
class App : MultiDexApplication() {

    private var refWatcher: RefWatcher? = null

    companion object {

        private val TAG = "App"

        var context: Context by Delegates.notNull()
            private set//  对于属性context，如果你想改变访问的可见性，但是又不想改变它的默认实现，那么你就可以定义set和get但不进行实现。

        lateinit var instance: Application

        fun getRefWatcher(context: Context): RefWatcher? {
            val app = context.applicationContext as App
            return app.refWatcher
        }

    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)//友盟bug
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        context = applicationContext
        SpiderMan.init(this)//奔溃日志
        refWatcher = setupLeakCanary()
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks)
        initLoggerConfig()
        //初始化数据库
        LitePal.initialize(this)
        QupaiHttpFinal.getInstance().initOkHttpFinal();
        DownloaderManager.getInstance().init(this)
        UpdateAppUtils.init(context)
        //        友盟统计
        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:【友盟+】 AppKey
         * 参数3:【友盟+】 Channel
         * 参数4:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数5:Push推送业务的secret
         */
        UMConfigure.init(this,"5eba4333dbc2ec080967a720","umeng",UMConfigure.DEVICE_TYPE_PHONE,"")
        /**
         * 设置组件化的Log开关
         * 参数: boolean 默认为false，如需查看LOG设置为true
         */
        UMConfigure.setLogEnabled(true)

        PlatformConfig.setQQZone("101876978", "347bbe40406eb62c18b935f947fb39a2")
        //微博此处有坑  https://api.weibo.com/oauth2/default.html 必须和微博开放平台设置的认证回调地址一致  否则授权不成功
        PlatformConfig.setSinaWeibo("923520257", "7ffbb04094abc7e34a5da6af0ed12f51","https://api.weibo.com/oauth2/default.html")
        // todo  替换
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0")
        //BUGly初始化
       // CrashReport.initCrashReport(applicationContext, "6ed7ce60df", false)
    }


    /**
     * 配置各个三方的key
     * 代码块
     * 101476089 为AppId
     * bf12db860a21d9e0ce217b37cbc1dec7为AppKey
     */
    private fun setupLeakCanary(): RefWatcher? {
        return if (LeakCanary.isInAnalyzerProcess(this)) {
            RefWatcher.DISABLED
        } else LeakCanary.install(this)
    }

    /**
     * 初始化LOGGER配置
     */
    private fun initLoggerConfig() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .logStrategy(LogCatStrategy())
                .tag("hcc")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }


    private val mActivityLifecycleCallbacks = object : Application.ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            Log.d(TAG, "onCreated: " + activity.componentName.className)
        }

        override fun onActivityStarted(activity: Activity) {
            Log.d(TAG, "onStart: " + activity.componentName.className)
        }

        override fun onActivityResumed(activity: Activity) {

        }

        override fun onActivityPaused(activity: Activity) {

        }

        override fun onActivityStopped(activity: Activity) {

        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

        }

        override fun onActivityDestroyed(activity: Activity) {
            Log.d(TAG, "onDestroy: " + activity.componentName.className)
        }
    }

}