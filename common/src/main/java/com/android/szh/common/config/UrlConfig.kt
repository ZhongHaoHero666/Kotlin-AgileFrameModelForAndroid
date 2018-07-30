package com.android.szh.common.config

import com.android.szh.common.BuildConfig

/**
 * @author sunzhonghao
 * @date 2018/7/30
 * desc:Url 配置类
 */
class UrlConfig {

    companion object {
        //测试环境
        val DOMAIN_BASE_TEST = ""
        //正式环境
        val DOMAIN_BASE_ONLINE = ""

        var DOMAIN_BASE = if (BuildConfig.DEBUG) DOMAIN_BASE_TEST else DOMAIN_BASE_ONLINE
    }

}