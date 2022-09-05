package com.lianwenhong.tradition.ui

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.lianwenhong.tradition.R
import com.lianwenhong.tradition.util.LogUtils
import com.lianwenhong.tradition.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel>() {

    private var txtActivity: TextView? = null
    private var txtViewModel: TextView? = null
    private var btnNumber: TextView? = null
    private var number = 0

    private var txtSeekValue: TextView? = null
    private var seekBar: SeekBar? = null
    private var gotoFragment: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }


    private fun initView() {
        txtActivity = findViewById(R.id.txt_number_activity)
        txtViewModel = findViewById(R.id.txt_number_viewmodel)
        btnNumber = findViewById(R.id.btn_number)
        txtActivity?.text = "Activity->number:$number"
        txtViewModel?.text = "ViewModel->number:${viewModel?.number}"

        txtSeekValue = findViewById(R.id.txt_seek_value)
        seekBar = findViewById(R.id.seek)
        gotoFragment = findViewById(R.id.btn_goto_fragment)

        demoDataReserve()
        demoShareData()
    }

    private fun demoDataReserve() {
        btnNumber?.setOnClickListener {
            number = 100
            viewModel?.number = 100

            txtActivity?.text = "Activity->number:$number"
            txtViewModel?.text = "ViewModel->number:${viewModel?.number}"
        }
    }

    /**
     * Activity中有一个SeekBar，Fragment中也有一个SeekBar，实现两者的SeekBar值同步
     */
    private fun demoShareData() {
        seekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                viewModel?.seekValue = progress
                txtSeekValue?.text = "${viewModel?.seekValue}"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        gotoFragment?.setOnClickListener {
            val mainFragment = MainFragment(true)
            if (!mainFragment.isAdded) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.add(R.id.f_me11, mainFragment)//动态添加
                transaction.addToBackStack("main_fragment")
                transaction.commit()//提交
            }
        }
    }

    override fun onResume() {
        super.onResume()
        txtSeekValue?.text = "${viewModel?.seekValue}"
    }

//    fun replaceFragment() {
//        // 1.获取FragmentManager，在活动中可以直接通过调用getFragmentManager()方法得到
//        val fm = supportFragmentManager
//        // 2.开启一个事务，通过调用beginTransaction()方法开启
//        val transaction = fm.beginTransaction();
//        // 3.向容器内添加或替换碎片，一般使用replace()方法实现，需要传入容器的id和待添加的碎片实例
//        transaction.replace(
//            R.id.f_me,
//            MainFragment(true)
//        );  //fr_container不能为fragment布局，可使用线性布局相对布局等。
//        // 4.使用addToBackStack()方法，将事务添加到返回栈中，填入的是用于描述返回栈的一个名字
//        transaction.addToBackStack(null);
//        // 5.提交事物,调用commit()方法来完成
//        transaction.commit();
//    }

//    private fun addFragment() {
//        if (!meFragment.isAdded) {
//            val transaction = fragmentManager.beginTransaction()
//            transaction.add(R.id.f_me, meFragment)//动态添加
//            transaction.commit()//提交
//        }
//    }
//
//    private fun removeFragment() {
//        val transaction = fragmentManager.beginTransaction()
//        transaction.remove(meFragment)
//        transaction.commit()//提交
//    }

    /**
     * 只有manifest文件中该Activity设置android:configChanges="orientation|screenSize"时才会调用此回调，否则都是销毁重建不会走到这个回调
     */
    override fun onConfigurationChanged(newConfig: Configuration) {
        LogUtils.d(" >>> onConfigurationChanged <<<")
        super.onConfigurationChanged(newConfig)
    }

    override fun bindViewModel(): MainViewModel? {
        return ViewModelProvider(this).get(MainViewModel::class.java)
    }

}