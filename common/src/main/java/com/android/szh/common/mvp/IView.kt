package com.android.szh.common.mvp

import android.content.Context

/**
 * @author sunzhonghao
 * @date 2018/7/25
 * desc:view 的超类接口
 */
interface IView {
    /**
     * 返回[Context]对象
     */
    abstract fun getContext(): Context
}