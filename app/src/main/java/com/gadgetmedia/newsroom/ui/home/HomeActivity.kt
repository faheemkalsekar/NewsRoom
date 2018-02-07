package com.gadgetmedia.newsroom.ui.home

import android.os.Bundle
import com.gadgetmedia.newsroom.R
import dagger.android.support.DaggerAppCompatActivity


class HomeActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }
}
