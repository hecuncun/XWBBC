package com.cvnchina.xingwanban.ui.activity

import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.base.BaseActivity
import kotlinx.android.synthetic.main.activity_age_description.*

/**
 * Created by hecuncun on 2020-5-2
 */
class AgeDescriptionActivity:BaseActivity() {
    override fun attachLayoutRes(): Int {
       return R.layout.activity_age_description
    }

    override fun initData() {
    }

    override fun initView() {
    }

    override fun initListener() {
        rl_des.setOnClickListener {
            finish()
        }
    }
}