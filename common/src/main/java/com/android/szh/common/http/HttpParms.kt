package com.android.szh.common.http

/**
 * @author sunzhonghao
 * @date 2018/7/30
 * desc:公用的网络请求参数处理
 */
class HttpParms {

    companion object {
        /**
         * 获取公用的请求体
         */
        fun getCommonQueryParms(): Map<String, String> {
            val commonQueryParms: HashMap<String, String> = hashMapOf()
            commonQueryParms.put("commonQueryParams1", "commonQueryParams1")
            commonQueryParms.put("commonQueryParams2", "commonQueryParams2")
            return commonQueryParms
        }

        /**
         * 获取公用的请求头
         */
        fun getCommonHeaderParms(): Map<String, String> {
            val commonQueryParms: HashMap<String, String> = hashMapOf()
            commonQueryParms.put("commonHeaderParams1", "commonHeaderParams1")
            commonQueryParms.put("commonHeaderParams2", "commonHeaderParams2")
            return commonQueryParms
        }
    }
}