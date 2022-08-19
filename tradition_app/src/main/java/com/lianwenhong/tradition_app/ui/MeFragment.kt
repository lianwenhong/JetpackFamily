package com.lianwenhong.tradition_app.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.lianwenhong.jetpackfamily.util.LogUtils
import com.lianwenhong.tradition_app.R
import com.lianwenhong.tradition_app.viewmodel.MeViewModel

class MeFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fViewModel = ViewModelProvider(this).get(MeViewModel::class.java)
        fViewModel.let {
            lifecycle.addObserver(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_me, container)
        LogUtils.d("$view")
        return inflater.inflate(R.layout.fragment_me, container, false)
    }
}