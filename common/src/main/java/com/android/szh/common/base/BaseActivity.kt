package com.android.szh.common.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.szh.common.mvp.IView
import com.android.szh.common.util.ReflexHelper

/**
 * @author sunzhonghao
 * @date 2018/7/25
 * desc:activity基类
 */
abstract class BaseActivity<out Presenter : BasePresenter<*, *>> : AppCompatActivity(), IView {

    private lateinit var mPresenter: Presenter

    private lateinit var mContext: Context


    fun getPresenter(): Presenter {
        return mPresenter
    }


    /**
     * @return 获取context
     */
    override fun getContext(): Context {
        return mContext
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        mContext = this

        beforeSuper()                         // 初始化(super.onCreate(savedInstanceState)之前调用)

        super.onCreate(savedInstanceState)

        if (intent != null) {
            handleIntent(intent)              // 处理Intent(主要用来获取其中携带的参数)
        }

        setContentView(getContentLayoutId())  // 加载页面布局

        initMVP()

        initView()

        loadData()
    }

    /**
     * 初始化Mvp组件
     */
    private fun initMVP() {
        mPresenter = ReflexHelper.getTypeInstance(this, 0)
        //TODO 编译期错误
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