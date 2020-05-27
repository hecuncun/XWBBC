package com.cvnchina.xingwanban.ui.activity

import com.cvnchina.xingwanban.R
import com.cvnchina.xingwanban.base.BaseActivity
import kotlinx.android.synthetic.main.item_problem_list.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by hecuncun on 2020-5-13
 */
class ProblemDetailActivity : BaseActivity() {
    override fun attachLayoutRes() = R.layout.activity_problem_detail

    override fun initData() {
        val q = intent.getStringExtra("q")
        val a = intent.getStringExtra("a")
        tv_a.text = a
        tv_q.text = q
    }

    override fun initView() {
        toolbar_title.text = "问题详情"
    }

    override fun initListener() {

    }
}