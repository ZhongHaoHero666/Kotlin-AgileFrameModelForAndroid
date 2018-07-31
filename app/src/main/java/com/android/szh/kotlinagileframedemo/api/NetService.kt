package com.android.szh.kotlinagileframedemo.api

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 * @author sunzhonghao
 * @date 2018/7/31
 * desc:
 */
interface NetService {
    /**
     * 获取城市信息
     */
    @GET("/cityjson?ie=utf-8&qq-pf-to=pcqq.c2c")
     fun getCityInfo(): Observable<ResponseBody>
}