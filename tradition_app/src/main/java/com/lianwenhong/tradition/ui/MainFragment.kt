package com.lianwenhong.tradition.ui

import android.content.Context
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.lianwenhong.tradition.R
import com.lianwenhong.tradition.util.LogUtils
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
        val test: TextView = view.findViewById(R.id.id_test)
        txtSeekValue = view.findViewById(R.id.txt_seek_value)
        seekBar = view.findViewById(R.id.seek)
        if (useParentViewModel) {
            txtSeekValue?.text = "${(fViewModel as MainViewModel).seekValue}"
            seekBar?.progress = (fViewModel as MainViewModel).seekValue
        } else {
            txtSeekValue?.text = "${(fViewModel as MainFragmentViewModel).seekValue}"
            seekBar?.progress = (fViewModel as MainFragmentViewModel).seekValue
        }
        seekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    if (useParentViewModel) {
                        (fViewModel as MainViewModel).seekValue = progress
                        txtSeekValue?.text = "${(fViewModel as MainViewModel).seekValue}"
                    } else {
                        (fViewModel as MainFragmentViewModel).seekValue = progress
                        txtSeekValue?.text = "${(fViewModel as MainFragmentViewModel).seekValue}"
                    }
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        if (useParentViewModel) {
                (fViewModel as MainViewModel).userName.observe(viewLifecycleOwner) {
//                Toast.makeText(
//                    context,
//                    "数据改变了:$it",
//                    Toast.LENGTH_SHORT
//                ).show()
                LogUtils.d("数据改变，test:$test")
                test.text = "$it"
            }
        }
        return view
    }

    override fun bindViewModel(useParentViewModel: Boolean): ViewModel? {
        if (useParentViewModel) {
            return activity?.let { ViewModelProvider(it)[MainViewModel::class.java] }
        } else {
            return ViewModelProvider(this)[MainFragmentViewModel::class.java]
        }
    }

    override fun onDestroyView() {
        LogUtils.d(" onDestroyView ")
        (fViewModel as MainViewModel).userName.value = "lisi"
        super.onDestroyView()

    }

    override fun onDestroy() {
//        SystemClock.sleep(2000)
        LogUtils.d(" onDestroy ")
        (fViewModel as MainViewModel).userName.value = "zhangsan"
        super.onDestroy()
//        LogUtils.d(" Destroy的时候viewModel:${(fViewModel as MainFragmentViewModel).abc.value}")
    }


//    private fun addFragment() {
//        if (!childFragment.isAdded) {
//            val transaction = parentFragmentManager.beginTransaction()
//            transaction.add(R.id.f_me, meFragment)//动态添加
//            transaction.commit()//提交
//        }
//    }


}