package com.lianwenhong.tradition_app.viewmodel

import android.util.MutableInt
import androidx.lifecycle.LifecycleOwner
import com.lianwenhong.jetpackfamily.util.LogUtils
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ActivityViewModel() {

    var number: Int = 0

    override fun onCreate(owner: LifecycleOwner) {
        LogUtils.d("${owner.javaClass.simpleName} invoke onCreate")
    }
}