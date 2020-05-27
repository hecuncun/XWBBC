package com.cvnchina.xingwanban.ui.activity

import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.base.BaseActivity
import com.cvnchina.xingwanban.event.VisiableEvent
import kotlinx.android.synthetic.main.activity_can_show.*
import kotlinx.android.synthetic.main.toolbar.*
import org.greenrobot.eventbus.EventBus

/**
 * Created by hecuncun on 2020-5-10
 */
class CanShowActivity : BaseActivity() {
    override fun attachLayoutRes(): Int = R.layout.activity_can_show

    override fun initData() {

    }

    override fun initView() {
        toolbar_title.text = "谁可以看"
    }

    override fun initListener() {
        rl_public.setOnClickListener {
            iv_public.setImageResource(R.mipmap.icon_selected)
            iv_private.setImageResource(R.mipmap.icon_normal)
            EventBus.getDefault().post(VisiableEvent(true))
            finish()
        }
        rl_private.setOnClickListener {
            iv_private.setImageResource(R.mipmap.icon_selected)
            iv_public.setImageResource(R.mipmap.icon_normal)
            EventBus.getDefault().post(VisiableEvent(false))
            finish()
        }
    }
}