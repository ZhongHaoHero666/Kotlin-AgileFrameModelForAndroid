package com.android.szh.common.base

import com.android.szh.common.mvp.IPresenter
import com.android.szh.common.mvp.IView
import io.reactivex.disposables.Disposable

/**
 * @author sunzhonghao
 * @date 2018/7/25
 * desc:
 */
class BasePresenter<Model, View : IView> : IPresenter<Model, View> {
    override fun add(disposable: Disposable): Boolean {
        return false
    }

    override fun remove(disposable: Disposable): Boolean {
        return false
    }

    override fun attachView(view: View) {

    }

    override fun unsubscribe() {

    }

    override fun detachView() {

    }
}