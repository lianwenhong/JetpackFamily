package com.lianwenhong.tradition.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lianwenhong.tradition.R
import com.lianwenhong.tradition.viewmodel.MainFragmentViewModel
import com.lianwenhong.tradition.viewmodel.MainViewModel

class MainFragment(override val useParentViewModel: Boolean) : BaseFragment<ViewModel>() {

    private var txtSeekValue: TextView? = null
    private var seekBar: SeekBar? = null

    /**
     * 这里使用的ViewModel是Activity中的，所以就实现了Activity与Fragment的数据共享
     * 同样的，如果要实现Fragment和子Fragment之间的数据共享，只需要在子Fragment中使用父Fragment作为ViewModelStoreOwner
     * 代码：
     * parentFragment?.let { fViewModel = ViewModelProvider(it).get(MainViewModel::class.java) }
     * */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        txtSeekValue = view.findViewById(R.id.txt_seek_value)
        txtSeekValue?.text = "${(fViewModel as MainViewModel).seekValue}"
        seekBar = view.findViewById(R.id.seek)
        seekBar?.progress = (fViewModel as MainViewModel).seekValue
        seekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    (fViewModel as MainViewModel).seekValue = progress
                    txtSeekValue?.text = "${(fViewModel as MainViewModel).seekValue}"
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        return view
    }

    override fun bindViewModel(useParentViewModel: Boolean): ViewModel? {
        if (useParentViewModel) {
            return activity?.let { ViewModelProvider(it)[MainViewModel::class.java] }
        } else {
            return ViewModelProvider(this)[MainFragmentViewModel::class.java]
        }
    }

//    private fun addFragment() {
//        if (!childFragment.isAdded) {
//            val transaction = parentFragmentManager.beginTransaction()
//            transaction.add(R.id.f_me, meFragment)//动态添加
//            transaction.commit()//提交
//        }
//    }


}