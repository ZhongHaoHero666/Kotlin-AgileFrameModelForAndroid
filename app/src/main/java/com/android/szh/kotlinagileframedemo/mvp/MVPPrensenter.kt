package com.android.szh.kotlinagileframedemo.mvp

import android.text.TextUtils
import com.android.szh.kotlinagileframedemo.entiy.CityInfo
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

/**
 * @author sunzhonghao
 * @date 2018/7/26
 * desc:MVPPrensenter      MVP 架构演示类 - presenter
 */
class MVPPrensenter : MVPContract.Presenter<MVPModel>() {
    override fun loadData() {
        mModel.loadData()
                .subscribeBy(
                        onNext = {
                            try {
                                val cityInfo = CityInfo()
                                val result = it.string()
                                if (!TextUtils.isEmpty(result) && result.contains("{") && result.contains("}")) {
                                    val start = result.indexOf("{")
                                    val end = result.indexOf("}")
                                    val content = result.substring(start, end + 1)
                                    val jsonObject = JSONObject(content)
                                    val ipAddress = jsonObject.getString("cip")
                                    val cityId = jsonObject.getString("cid")
                                    val cityName = jsonObject.getString("cname")
                                    cityInfo.setCityId(cityId)
                                    cityInfo.setCityName(cityName)
                                    cityInfo.setIpAddress(ipAddress)
                                }
                                mView!!.handleResult(cityInfo.toString())
                            } catch (e: IOException) {
                                e.printStackTrace()
                            } catch (e: JSONException) {
                                e.printStackTrace()
                            }
                        },
                        onError = { println(it) })
                .addTo(compositeDisposable)
    }
}