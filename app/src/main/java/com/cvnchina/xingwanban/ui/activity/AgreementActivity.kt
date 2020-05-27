package com.cvnchina.xingwanban.ui.activity

import android.content.Intent
import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.base.BaseActivity
import kotlinx.android.synthetic.main.activity_agreement.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by hecuncun on 2020-5-3
 */
class AgreementActivity :BaseActivity() {
    override fun attachLayoutRes(): Int {
      return R.layout.activity_agreement
    }

    override fun initData() {

    }

    override fun initView() {
        toolbar_title.text="政策与协议"

    }

    override fun initListener() {
        tv_user_agreement.setOnClickListener {
            val intent = Intent(this,WebViewActivity::class.java)
            intent.putExtra("type",2)
            startActivity(intent)
        }
        tv_private.setOnClickListener {
            val intent = Intent(this,WebViewActivity::class.java)
            intent.putExtra("type",3)
            startActivity(intent)
        }
    }
}