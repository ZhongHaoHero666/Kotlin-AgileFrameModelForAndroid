package com.android.szh.kotlinagileframedemo

import com.android.szh.common.base.BasePresenter
import com.android.szh.common.mvp.IModel
import com.android.szh.common.mvp.IView
import io.reactivex.Observable
import okhttp3.ResponseBody

/**
 * @author sunzhonghao
 * @date 2018/7/26
 * desc:
 */
interface MainContract {
    interface Model : IModel {
        fun loadData(): Observable<ResponseBody>
    }

    interface View : IView {
        fun handleResult(result: String)
    }


    abstract class Presenter<ModelImp : Model> : BasePresenter<Model, View>() {
        abstract fun loadData()
    }
}