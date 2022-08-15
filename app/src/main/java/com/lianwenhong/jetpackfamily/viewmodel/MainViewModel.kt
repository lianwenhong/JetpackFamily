package com.lianwenhong.jetpackfamily.viewmodel

import android.app.Activity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.lianwenhong.jetpackfamily.util.LogUtils

class MainViewModel(lifecycle: Lifecycle) : ActivityViewModel(lifecycle) {
    override fun onCreate(owner: LifecycleOwner) {
        LogUtils.d("${owner.javaClass.simpleName} invoke onCreate")
    }
}