package com.android.szh.kotlinagileframedemo.mvptest

import com.android.szh.common.http.HttpManager
import com.android.szh.common.rx.applySchedulers
import com.android.szh.kotlinagileframedemo.api.NetService
import io.reactivex.Observable
import okhttp3.ResponseBody

/**
 * @author sunzhonghao
 * @date 2018/7/26
 * desc:
 */
class MainModel : MainContract.Model {
    override fun loadData(): Observable<ResponseBody> {
        return HttpManager
                .create(NetService::class.java)
                .getCityInfo()
                .compose(applySchedulers())
    }
}