package com.lianwenhong.jetpackfamily.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LifecycleOwner
import com.lianwenhong.jetpackfamily.util.LogUtils

class MainViewModel : ActivityViewModel() {

    var number: MutableState<Int> = mutableStateOf(0)

    override fun onCreate(owner: LifecycleOwner) {
        LogUtils.d("${owner.javaClass.simpleName} invoke onCreate")
    }
}