package com.android.szh.common.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.szh.common.mvp.IView
import com.android.szh.common.util.ReflexHelper

/**
 * @author sunzhonghao
 * @date 2018/8/3
 * desc:BaseFragment
 */
abstract class BaseFragment<Presenter : BasePresenter<*, *>> : androidx.fragment.app.Fragment(), IView {

    protected lateinit var mPresenter: Presenter

    protected lateinit var mContext: Context

    protected lateinit var rootView: View


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mContext = this.activity!!

        val contentLayoutID: Int = getContentLayoutId()
        rootView = if (contentLayoutID == 0) {
            super.onCreateView(inflater, container, savedInstanceState)!!
        } else {
            inflater.inflate(contentLayoutID, null)
        }

        initMVP()

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //在View创建之后 initView，这样直接通过Id调用View才不会为空
        initView()

        loadData()
    }


    /**
     * 初始化Mvp组件
     */
    private fun initMVP() {
        mPresenter = ReflexHelper.getTypeInstance(this, 0)
        mPresenter.attachView(this)
    }

    /**
     * 页面销毁时执行的逻辑
     * 反注册 和反订阅
     */
    override fun onDestroy() {
        mPresenter.detachView()
        mPresenter.unSubscribe()
        super.onDestroy()
    }

    /**
     * 初始化数据
     */
    abstract fun initView()


    /**
     * 返回页面布局ID
     */
    abstract fun getContentLayoutId(): Int


    /**
     * 加载数据
     */
    protected open fun loadData() {}

    /**
     *在onCreate()方法之前执行的方法
     */
    protected open fun beforeSuper() {}

    /**
     * 处理页面之间传递的数据
     */
    protected open fun handleIntent(intent: Intent) {}

}