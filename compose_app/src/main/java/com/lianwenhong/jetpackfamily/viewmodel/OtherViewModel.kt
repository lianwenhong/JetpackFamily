package com.lianwenhong.jetpackfamily.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class OtherViewModel : ActivityViewModel() {
    var number: MutableState<Int> = mutableStateOf(0)
}