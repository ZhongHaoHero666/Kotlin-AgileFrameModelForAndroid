package com.android.szh.common.rx

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * @author sunzhonghao
 * @date 2018/7/31
 * desc:rxHelper
 */

fun <T> applySchedulers(): ObservableTransformer<T, T> {
    return ObservableTransformer { observable ->
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
