package com.android.szh.kotlinagileframedemo.mvptest

import com.android.szh.common.base.BaseFragment
import com.android.szh.kotlinagileframedemo.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author sunzhonghao
 * @date 2018/8/3
 * desc:MainFragment
 */
class MainFragment : BaseFragment<MainPrensenter>(), MainContract.View {
    override fun handleResult(result: String) {
        tv_test.text = result
    }

    override fun getContentLayoutId(): Int {
        return R.layout.fragment_main
    }

    override fun initView() {

    }

    override fun loadData() {
        mPresenter.loadData()
    }
}