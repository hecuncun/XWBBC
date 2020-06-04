package com.cvnchina.xingwanban.ui.activity

import android.annotation.SuppressLint
import android.os.Build
import android.view.KeyEvent
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.bean.AgreementBean
import com.cvnchina.xingwanban.net.CallbackObserver
import com.cvnchina.xingwanban.net.SLMRetrofit
import com.cvnchina.xingwanban.net.ThreadSwitchTransformer
import com.cvnchina.xingwanban.utils.AndroidBug5497Workaround
import com.cvnchina.xingwanban.widget.MyWebView
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by hecuncun on 2019/12/14
 *
 * type:协议类型 1-联系我们 2-用户协议 3-隐私协议 4-关于我们  5.视频评论
 */
class WebViewActivity : BaseActivity() {
    private var type = 0
    private var url =""
    private var mWebView: MyWebView? = null
    override fun attachLayoutRes(): Int= R.layout.activity_webview
    override fun initData() {
        //获取富文本内容
        if (type in 1..4){
            val agreementCall = SLMRetrofit.instance.api.agreementCall(type.toString())
            agreementCall.compose(ThreadSwitchTransformer()).subscribe(object :CallbackObserver<AgreementBean>(){
                override fun onSucceed(t: AgreementBean, desc: String?) {
                    url=t.content
                    setUrl(type)
                }

                override fun onFailed() {

                }
            })
        }

        if (type==5){
            url=intent.getStringExtra("url")!!
            setUrl(type)
        }

    }

    /**
     * 富文本的样式做到适配屏幕
     */
    private fun getHtmlData(bodyHTML: String): String {
        val head = ("<head>"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> "
                + "<style>img{max-width: 100%; width:100%; height:auto;}*{margin:0px;}</style>"
                + "</head>")
        return "<html>$head<body>$bodyHTML</body></html>"
    }

    override fun initView() {
        AndroidBug5497Workaround.assistActivity(this);
        mWebView=findViewById(R.id.webView)
        type = intent.extras!!.getInt("type")
        when(type){
            1-> toolbar_title.text="联系我们"
            2-> toolbar_title.text="用户协议"
            3-> toolbar_title.text="隐私协议"
            4-> toolbar_title.text="关于我们"
        }
        mWebView!!.webViewClient=object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url: String?
            ): Boolean {
          view?.loadUrl(url)
            return true
            }
        }
        initWeb()


    }

    private fun setUrl(type:Int) {
        mWebView?.post {
           when(type){
               1,2,3,4->mWebView?.loadDataWithBaseURL(null,getHtmlData(url), "text/html" , "utf-8", null)
               5->{mWebView?.loadUrl(url)}
               else->{}
           }
        }


    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWeb() {
        val settings = mWebView?.settings
        settings?.defaultTextEncodingName = "utf-8"
        settings?.javaScriptEnabled = true
        settings?.setSupportZoom(false)
        settings?.builtInZoomControls = true
        settings?.useWideViewPort = true
        settings?.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
        settings?.loadWithOverviewMode = true
        //隐藏缩放控件
        settings?.displayZoomControls = false
        //解决HTTPS协议下出现的mixed content问题
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings?.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        settings?.cacheMode = WebSettings.LOAD_DEFAULT
        settings?.domStorageEnabled = true
        settings?.databaseEnabled = true
        settings?.setAppCachePath(cacheDir.path)
        settings?.setAppCacheEnabled(true)
    }

    override fun initListener() {

    }

    override fun onPause() {
        super.onPause()
        mWebView?.pauseTimers()
    }

    override fun onResume() {
        super.onResume()
        mWebView?.resumeTimers()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (mWebView?.canGoBack()!!) {
            mWebView?.goBack()
        } else {
            finish()
        }
        return true
    }
}