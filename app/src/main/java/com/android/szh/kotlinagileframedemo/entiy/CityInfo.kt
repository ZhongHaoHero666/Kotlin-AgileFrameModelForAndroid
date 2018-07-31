package com.android.szh.kotlinagileframedemo.entiy

import android.text.TextUtils

/**
 * @author sunzhonghao
 * @date 2018/7/31
 * desc:
 */
class CityInfo {
    private val URL = "http://pv.sohu.com/cityjson?ie=utf-8&qq-pf-to=pcqq.c2c"
    private val UNKNOWN = "未知"

    private var cityId: String? = null
    private var cityName: String? = null
    private var ipAddress: String? = null
    private var dateTime: String? = null

    fun getCityId(): String? {
        return if (TextUtils.isEmpty(cityId)) {
            UNKNOWN
        } else cityId
    }

    fun setCityId(cityId: String) {
        this.cityId = cityId
    }

    fun getCityName(): String? {
        return if (TextUtils.isEmpty(cityName)) {
            UNKNOWN
        } else cityName
    }

    fun setCityName(cityName: String) {
        this.cityName = cityName
    }

    fun getIpAddress(): String? {
        return if (TextUtils.isEmpty(ipAddress)) {
            UNKNOWN
        } else ipAddress
    }

    fun setIpAddress(ipAddress: String) {
        this.ipAddress = ipAddress
    }

    fun getDateTime(): String? {
        return if (TextUtils.isEmpty(dateTime)) {
            UNKNOWN
        } else dateTime
    }

    fun setDateTime(dateTime: String) {
        this.dateTime = dateTime
    }

    override fun toString(): String {
        return "CityInfo{" +
                "cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}'
    }
}