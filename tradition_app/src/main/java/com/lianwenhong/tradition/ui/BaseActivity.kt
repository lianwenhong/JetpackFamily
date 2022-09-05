package com.lianwenhong.tradition.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lianwenhong.tradition.viewmodel.ActivityViewModel

abstract class BaseActivity<T : ActivityViewModel> : AppCompatActivity() {
    var viewModel: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = bindViewModel()
        viewModel?.let { lifecycle.addObserver(it) }
    }

    abstract fun bindViewModel(): T?
}