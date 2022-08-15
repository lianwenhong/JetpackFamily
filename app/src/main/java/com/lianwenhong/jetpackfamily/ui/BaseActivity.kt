package com.lianwenhong.jetpackfamily.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.lianwenhong.jetpackfamily.viewmodel.ActivityViewModel

abstract class BaseActivity : ComponentActivity() {
    var viewModel: ActivityViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = bindViewModel()

    }

    abstract fun bindViewModel(): ActivityViewModel?
}