package com.android.szh.kotlinagileframedemo

/**
 * @author sunzhonghao
 * @date 2018/7/26
 * desc:
 */
class MainPrensenter : MainContract.Presenter<MainModel>() {
    override fun loadData() {
        getView()!!.handleResult(getModel()!!.loadData())
    }
}