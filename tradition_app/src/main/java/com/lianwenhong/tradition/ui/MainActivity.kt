package com.lianwenhong.tradition.ui

import android.app.ProgressDialog.show
import android.content.res.Configuration
import android.os.Bundle
import android.os.SystemClock
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
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

    private var txtName: TextView? = null
    private var btnChangeInMain: TextView? = null
    private var btnChangeInOther: TextView? = null

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

        txtName = findViewById(R.id.txt_name)
        btnChangeInMain = findViewById(R.id.btn_change_in_main)
        btnChangeInOther = findViewById(R.id.btn_change_in_other)

        demoDataReserve()
        demoShareData()
        demoLiveData()
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
     * Activity????????????SeekBar???Fragment???????????????SeekBar??????????????????SeekBar?????????
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
            val transaction = supportFragmentManager.beginTransaction()
            if (!mainFragment.isAdded) {
                transaction.add(R.id.f_me11, mainFragment)//????????????
                transaction.addToBackStack("main_fragment")
                transaction.commit()//??????
            }

//            ??????Fragment???addToBackStack()??????
//            val transaction1 = supportFragmentManager.beginTransaction()
//            val secondFragment = SecondFragment()
//            if (!secondFragment.isAdded) {
//                transaction1.replace(R.id.f_me11, secondFragment)
//                transaction1.addToBackStack(null)
//                transaction1.commit()
//            }
        }
    }

    private fun demoLiveData() {
//        LiveData????????????
//        viewModel?.userName?.observe(this) { txtName?.text = "NAME:$it" }
//        viewModel?.userName?.observe(this) {
//            Toast.makeText(this, "USERNAME??????", Toast.LENGTH_SHORT).show()
//        }

//        ?????????????????????????????????????????????LifecycleOwner??????
//        val observer = MyObserver()
//        viewModel?.userName?.observe(this) { txtName?.text = "NAME:$it" }
//        viewModel?.userName?.observe(this) {
//            Toast.makeText(this, "USERNAME??????", Toast.LENGTH_SHORT).show()
//        }
        btnChangeInMain?.setOnClickListener {
            viewModel?.userName?.value = "MAIN"
            viewModel?.userName?.observe(this) { txtName?.text = "NAME:$it" }
//            ?????????????????????????????????????????????
//            viewModel?.userName?.observeForever{txtName?.text = "NAME:$it"}
        }

        btnChangeInOther?.setOnClickListener {
            val thread = Thread {
                viewModel?.userName?.postValue("OTHER")
            }
            SystemClock.sleep(2000)
            thread.start()
        }
    }

    class MyObserver : Observer<String> {
        override fun onChanged(t: String?) {
            LogUtils.d(" MY OBSERVER ")
        }
    }

    /**
     * ??????manifest????????????Activity??????android:configChanges="orientation|screenSize"???????????????????????????????????????????????????????????????????????????
     */
    override fun onConfigurationChanged(newConfig: Configuration) {
        LogUtils.d(" >>> onConfigurationChanged <<<")
        super.onConfigurationChanged(newConfig)
    }

    override fun bindViewModel(): MainViewModel? {
        return ViewModelProvider(this).get(MainViewModel::class.java)
    }

}