package com.lianwenhong.tradition_app.ui

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.lianwenhong.jetpackfamily.util.LogUtils
import com.lianwenhong.tradition_app.R
import com.lianwenhong.tradition_app.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel>() {

    private var textview: TextView? = null
    private var btnPlus: Button? = null
    private var btnSub: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutInflater
        initView()
    }

    private fun initView() {
        textview = findViewById(R.id.text_hello)
        btnPlus = findViewById(R.id.btn_plus)
        btnSub = findViewById(R.id.btn_sub)


        textview?.text = viewModel?.number?.toString()

        btnPlus?.setOnClickListener {
            viewModel?.apply { number++ }
            addFragment()

        }

        btnSub?.setOnClickListener {
            viewModel?.apply { number-- }
            removeFragment()
        }
    }

    fun replaceFragment() {
        // 1.获取FragmentManager，在活动中可以直接通过调用getFragmentManager()方法得到
        val fm = supportFragmentManager
        // 2.开启一个事务，通过调用beginTransaction()方法开启
        val transaction = fm.beginTransaction();
        // 3.向容器内添加或替换碎片，一般使用replace()方法实现，需要传入容器的id和待添加的碎片实例
        transaction.replace(R.id.f_me, MeFragment());  //fr_container不能为fragment布局，可使用线性布局相对布局等。
        // 4.使用addToBackStack()方法，将事务添加到返回栈中，填入的是用于描述返回栈的一个名字
        transaction.addToBackStack(null);
        // 5.提交事物,调用commit()方法来完成
        transaction.commit();
    }


    private val fragmentManager = supportFragmentManager
    private val meFragment = MeFragment()

    private fun addFragment() {
        if (!meFragment.isAdded) {
            val transaction = fragmentManager.beginTransaction()
            transaction.add(R.id.f_me, meFragment)//动态添加
            transaction.commit()//提交
        }
    }

    private fun removeFragment() {
        val transaction = fragmentManager.beginTransaction()
        transaction.remove(meFragment)
        transaction.commit()//提交
    }

    /**
     * 只有manifest文件中该Activity设置android:configChanges="orientation|screenSize"时才会调用此回调，否则都是销毁重建不会走到这个回调
     */
    override fun onConfigurationChanged(newConfig: Configuration) {
        LogUtils.d(" >>> onConfigurationChanged <<<")
        super.onConfigurationChanged(newConfig)
    }

    override fun bindViewModel(): MainViewModel? {
        return ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}