package com.android.szh.common.rx

import io.reactivex.FlowableSubscriber
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.internal.subscriptions.SubscriptionHelper
import org.reactivestreams.Subscription
import java.util.concurrent.atomic.AtomicReference

/**
 * @author sunzhonghao
 * @date 2018/7/31
 * desc:基于Flowable的观察者基类
 */
class BaseSubscriber<T>: AtomicReference<Subscription>(), FlowableSubscriber<T>, Subscription, Disposable {

    override fun onSubscribe(@NonNull subscription: Subscription) {

    }

    override fun onNext(t: T) {

    }

    override fun onError(t: Throwable) {

    }

    override fun onComplete() {

    }

    override fun dispose() {
        this.cancel()
    }

    override fun isDisposed(): Boolean {
        return this.get() === io.reactivex.internal.subscriptions.SubscriptionHelper.CANCELLED
    }

    override fun request(n: Long) {
        this.get().request(n)
    }

    override fun cancel() {
        SubscriptionHelper.cancel(this)
    }
}