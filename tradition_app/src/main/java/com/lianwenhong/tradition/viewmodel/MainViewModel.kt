package com.lianwenhong.tradition.viewmodel

import android.util.MutableInt
import androidx.lifecycle.*
import com.lianwenhong.tradition.util.LogUtils
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ActivityViewModel() {

    var number: Int = 0
    var seekValue: Int = 0

    val userName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    override fun onCreate(owner: LifecycleOwner) {
        LogUtils.d("${owner.javaClass.simpleName} invoke onCreate")
    }

    override fun onCleared() {
        super.onCleared()
    }

}
