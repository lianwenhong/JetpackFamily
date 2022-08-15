package com.lianwenhong.jetpackfamily.observer

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.lianwenhong.jetpackfamily.util.LogUtils

class ServiceLifecycleObserver : DefaultLifecycleObserver {
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