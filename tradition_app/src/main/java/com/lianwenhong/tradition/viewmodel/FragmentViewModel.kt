package com.lianwenhong.tradition.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.lianwenhong.tradition.util.LogUtils

/**
 *  抽象针对Fragment页面的ViewModel
 *  可在此ViewModel中实现一些基础功能，例如生命周期监测
 */
open class FragmentViewModel : ViewModel(), DefaultLifecycleObserver {



}