package com.lianwenhong.tradition_app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.lianwenhong.tradition_app.viewmodel.ActivityViewModel

abstract class BaseActivity<T : ActivityViewModel> : AppCompatActivity() {
    var viewModel: T? = null
        get() = field

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = bindViewModel()
        viewModel?.let { lifecycle.addObserver(it) }
    }

    abstract fun bindViewModel(): T?
}