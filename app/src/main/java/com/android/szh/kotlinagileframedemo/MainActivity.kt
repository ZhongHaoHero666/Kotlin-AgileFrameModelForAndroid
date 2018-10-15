package com.android.szh.kotlinagileframedemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.szh.kotlinagileframedemo.mvp.MVPActivity
import kotlinx.android.synthetic.main.activity_guide.*

/**
 * @author sunzhonghao
 * @date 2018/10/15
 * desc:MainActivity
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)

        test_mvp.setOnClickListener { startActivity(Intent(this, MVPActivity::class.java)) }
        test_mvvm.setOnClickListener { startActivity(Intent(this, MVPActivity::class.java)) }

    }
}