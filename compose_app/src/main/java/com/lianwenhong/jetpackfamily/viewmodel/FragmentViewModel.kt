package com.lianwenhong.jetpackfamily.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.lianwenhong.jetpackfamily.util.LogUtils

/**
 *  抽象针对Fragment页面的ViewModel
 *  可在此ViewModel中实现一些基础功能，例如生命周期监测
 */
open class FragmentViewModel(lifecycle: Lifecycle) : DefaultLifecycleObserver {

    init {
        lifecycle.addObserver(this)
    }

    override fun onCreate(owner: LifecycleOwner) {
        LogUtils.d("${owner.javaClass.simpleName} invoke onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        LogUtils.d("${owner.javaClass.simpleName} invoke onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        LogUtils.d("${owner.javaClass.simpleName} invoke onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        LogUtils.d("${owner.javaClass.simpleName} invoke onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        LogUtils.d("${owner.javaClass.simpleName} invoke onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        LogUtils.d("${owner.javaClass.simpleName} invoke onDestroy")
    }

}