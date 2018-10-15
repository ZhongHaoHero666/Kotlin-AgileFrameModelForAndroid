package com.android.szh.kotlinagileframedemo.mvp

import com.android.szh.common.http.HttpManager
import com.android.szh.common.rx.applySchedulers
import com.android.szh.kotlinagileframedemo.api.NetService
import io.reactivex.Observable
import okhttp3.ResponseBody

/**
 * @author sunzhonghao
 * @date 2018/7/26
 * desc:MVPModel   MVP 架构演示类 - model
 */
class MVPModel : MVPContract.Model {
    override fun loadData(): Observable<ResponseBody> {
        return HttpManager
                .create(NetService::class.java)
                .getCityInfo()
                .compose(applySchedulers())
    }
}