package com.android.szh.common.http

import com.android.szh.common.config.UrlConfig

/**
 * @author sunzhonghao
 * @date 2018/7/30
 * desc:HttpManager Http的管理类,封装httpClient，使用该类直接进行网络访问，面向使用者
 */
object  HttpManager {
    /**
     * 创建ApiService
     */
    fun <T> create(baseUrl: String, service: Class<T>): T {
        return HttpClient.mRetrofit.newBuilder()
                .baseUrl(UrlConfig.DOMAIN_BASE)
                .build()
                .create(service)
    }

    /**
     * 创建ApiService
     */
    fun <T> create(service: Class<T>): T {
        return HttpClient.mRetrofit.create(service)
    }
}