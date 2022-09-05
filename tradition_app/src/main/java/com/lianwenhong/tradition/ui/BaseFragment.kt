package com.lianwenhong.tradition.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.lianwenhong.tradition.util.LogUtils

abstract class BaseFragment<T : ViewModel> : Fragment(), DefaultLifecycleObserver {

    abstract val useParentViewModel: Boolean

    var fViewModel: T? = null

    abstract fun bindViewModel(useParentViewModel: Boolean): T?

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fViewModel = bindViewModel(useParentViewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super<Fragment>.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super<Fragment>.onStart()
    }

    override fun onResume() {
        super<Fragment>.onResume()
    }

    override fun onPause() {
        super<Fragment>.onPause()
    }

    override fun onStop() {
        super<Fragment>.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super<Fragment>.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
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