package com.lianwenhong.jetpackfamily.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.lianwenhong.jetpackfamily.viewmodel.ActivityViewModel

abstract class BaseActivity<T : ActivityViewModel> : ComponentActivity() {
    var viewModel: T? = null
        get() = field

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = bindViewModel()
        viewModel?.let { lifecycle.addObserver(it) }
    }

    abstract fun bindViewModel(): T?
}