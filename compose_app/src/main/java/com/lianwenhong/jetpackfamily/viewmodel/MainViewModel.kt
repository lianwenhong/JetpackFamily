package com.lianwenhong.jetpackfamily.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LifecycleOwner
import com.lianwenhong.jetpackfamily.util.LogUtils

class MainViewModel : ActivityViewModel() {

    // compose自身已经实现了响应式布局，数据源改变时会自动更新ui，否则这个number和mutableNumber数据的变化时并不能立即更新到ui上
    var number: Int = 0
    var mutableNumber: MutableState<Int> = mutableStateOf(0)

    override fun onCreate(owner: LifecycleOwner) {
        LogUtils.d("${owner.javaClass.simpleName} invoke onCreate")
    }
}