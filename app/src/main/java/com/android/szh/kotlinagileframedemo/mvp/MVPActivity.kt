package com.android.szh.kotlinagileframedemo.mvp

import com.android.szh.common.base.BaseActivity
import com.android.szh.kotlinagileframedemo.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author sunzhonghao
 * @date 2018/8/1
 * desc:MVPActivity  MVP 架构演示类 - view
 */
class MVPActivity : BaseActivity<MVPPrensenter>(), MVPContract.View {
    override fun handleResult(result: String) {
        tv_test.text = result
    }

    override fun getContentLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

    }

    override fun loadData() {
        mPresenter.loadData()
    }
}
