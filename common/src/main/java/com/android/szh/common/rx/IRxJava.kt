package com.android.szh.common.rx

import android.support.annotation.NonNull
import io.reactivex.disposables.Disposable

/**
 * @author sunzhonghao
 * @date 2018/7/25
 * desc: Observer 管理接口
 */
interface IRxJava {
    /**
     * 注册 Observer CompositeDisposable中统一管理
     */
     fun add(@NonNull disposable: Disposable): Boolean

    /**
     * 取消订阅指定的Observer
     */
     fun remove(@NonNull disposable: Disposable): Boolean

    /**
     * 取消订阅所有的Observer
     */
     fun unSubscribe()
}