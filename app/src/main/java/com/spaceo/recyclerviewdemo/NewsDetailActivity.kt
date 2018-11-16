package com.spaceo.recyclerviewdemo

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*


/**
 * Created by Amit Patoliya on 16/11/18.
 */
class NewsDetailActivity : AppCompatActivity() {


    private var title: String? = null
    private var date: String? = null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle = intent.extras
        if (bundle != null) {
            title = bundle.getString("title")
            date = bundle.getString("date")
        }

        txtTitle!!.text = title
        txtDate!!.text = date

    }
}