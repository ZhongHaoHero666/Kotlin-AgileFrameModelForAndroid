package com.android.szh.common.http

import com.android.szh.common.app.BaseApp
import com.android.szh.common.config.CACHE_SIZE
import com.android.szh.common.config.CONNECT_TIME_OUT
import com.android.szh.common.config.DOMAIN_BASE
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * @author sunzhonghao
 * @date 2018/7/30
 * desc:网路请求客户端
 * Kotlin 中的单例模式，需要理解一个特殊的类型，这个类型叫做object，这个object可不是Java中所有类的父类（Object），
 * 这个object 就是创建单例用的，我们都知道，Java中单例有懒汉式、饿汉式，双重检查锁等几种单例变种。但是在Kotlin中只要object一种单例实现方式。
 */
object HttpClient {
    var mRetrofit: Retrofit

    init {
        val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        //缓存文件
        val cacheFile = File(BaseApp.context.cacheDir, "retrofitCache")
        val cache = Cache(cacheFile, CACHE_SIZE) // 缓存的大小

        //httpClient
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(addQueryParameterInterceptor())     //请求体参数添加
                .addInterceptor(addHeaderInterceptor())             // 请求头参数
                .addInterceptor(loggingInterceptor)                 //日志,所有的请求响应度看到
                .cache(cache)  //添加缓存
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .build()

        //retrofit
        mRetrofit = Retrofit.Builder()
                .baseUrl(DOMAIN_BASE)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }

    /**
     * 设置请求头参数
     */
    private fun addHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val builder = originalRequest.newBuilder()

            //添加公用的Header参数
            val headerPrams: Map<String, String> = HttpParms.getCommonHeaderParms()
            for (entry in headerPrams.entries) {
                builder.header(entry.key, entry.value)
            }
            chain.proceed(builder.method(originalRequest.method(), originalRequest.body()).build())
        }
    }


    /**
     * 设置公共参数
     */
    private fun addQueryParameterInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val builder = originalRequest.url().newBuilder()

            //添加公用的Query参数
            val queryPrams: Map<String, String> = HttpParms.getCommonQueryParms()
            for (entry in queryPrams.entries) {
                builder.addQueryParameter(entry.key, entry.value)
            }
            chain.proceed(originalRequest.newBuilder().url(builder.build()).build())
        }
    }
}