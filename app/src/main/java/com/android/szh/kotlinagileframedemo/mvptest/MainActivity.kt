package com.android.szh.kotlinagileframedemo.mvptest

import com.android.szh.common.base.BaseActivity
import com.android.szh.kotlinagileframedemo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPrensenter>(), MainContract.View {
    override fun handleResult(result: String) {
        tv_test.text = result
    }

    override fun getContentLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        mPresenter.loadData()
    }
}
