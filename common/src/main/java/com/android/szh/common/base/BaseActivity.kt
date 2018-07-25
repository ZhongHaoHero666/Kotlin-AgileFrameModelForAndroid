package com.android.szh.common.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.szh.common.mvp.IView

/**
 * @author sunzhonghao
 * @date 2018/7/25
 * desc:activity基类
 */
abstract class BaseActivity<P : BasePresenter<*, *>> : AppCompatActivity(), IView {

    protected var mPresenter: P? = null
    private lateinit var mContext: Context

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

        initView()

        loadData()
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