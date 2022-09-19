package com.lianwenhong.tradition.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainFragmentViewModel : ViewModel() {
    var seekValue: Int = 0
    val abc: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    override fun onCleared() {
        super.onCleared()
        seekValue = 999
        abc.value = 100000
    }
}