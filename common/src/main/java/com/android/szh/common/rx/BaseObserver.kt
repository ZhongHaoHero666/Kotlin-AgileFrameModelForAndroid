package com.android.szh.common.rx

import io.reactivex.Observer
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.DisposableHelper
import io.reactivex.internal.util.EndConsumerHelper
import java.util.concurrent.atomic.AtomicReference

/**
 * @author sunzhonghao
 * @date 2018/7/31
 * desc:BaseObserver
 */
open class BaseObserver<T> : Observer<T>, Disposable {
    override fun onNext(t: T) {
    }

    private val s = AtomicReference<Disposable>()

    override fun onSubscribe(@NonNull s: Disposable) {
        if (EndConsumerHelper.setOnce(this.s, s, javaClass)) {
            onStart()
        }
    }

     fun onStart() {}

     fun onStop() {}

    override fun onComplete() {
        onStop()
    }

    override fun onError(e: Throwable) {
        onStop()
    }

    override fun isDisposed(): Boolean {
        return s.get() === DisposableHelper.DISPOSED
    }

    override fun dispose() {
        DisposableHelper.dispose(s)
    }

}