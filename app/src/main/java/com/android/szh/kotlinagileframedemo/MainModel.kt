package com.android.szh.kotlinagileframedemo

/**
 * @author sunzhonghao
 * @date 2018/7/26
 * desc:
 */
class MainModel : MainContract.Model {
    override fun loadData(): String {
        return "MVP"
    }
}