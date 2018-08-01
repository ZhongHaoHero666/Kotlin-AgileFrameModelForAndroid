package com.android.szh.common.config

import com.android.szh.common.BuildConfig

/**
 * @author sunzhonghao
 * @date 2018/7/30
 * desc:Url 配置类
 */


//测试环境
private const val DOMAIN_BASE_TEST = "http://pv.sohu.com"
//正式环境
private const val DOMAIN_BASE_ONLINE = "http://pv.sohu.com"
//一级域名，可以修改
var DOMAIN_BASE = if (BuildConfig.DEBUG) DOMAIN_BASE_TEST else DOMAIN_BASE_ONLINE