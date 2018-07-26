package com.android.szh.common.base

import com.android.szh.common.mvp.IModel
import com.android.szh.common.mvp.IPresenter
import com.android.szh.common.mvp.IView
import com.android.szh.common.util.ReflexHelper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author sunzhonghao
 * @date 2018/7/25
 * desc:BasePresenter
 */
open class BasePresenter<out Model : IModel, View : IView> : IPresenter<View> {

    private lateinit var mView: View
    private lateinit var mModel: Model


    private var compositeDisposable = CompositeDisposable()

    override fun add(disposable: Disposable): Boolean {
        return compositeDisposable.add(disposable)
    }

    override fun remove(disposable: Disposable): Boolean {
        return compositeDisposable.remove(disposable)
    }

    override fun attachView(view: View) {
        this.mView = view
        initModel()
    }

    private fun initModel() {
        mModel = ReflexHelper.getTypeInstance(this, 0)
    }

    override fun unSubscribe() {
        if (compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }

    override fun detachView() {
        //TODO 需要了解回收策略
//        this.mView = null
//        this.mModel = null
    }

    fun getModel(): Model? {
        return mModel
    }

    open fun getView(): View? {
        return mView
    }
}