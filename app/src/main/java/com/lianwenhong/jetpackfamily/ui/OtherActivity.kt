package com.lianwenhong.jetpackfamily.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.lianwenhong.jetpackfamily.R
import com.lianwenhong.jetpackfamily.viewmodel.OtherViewModel

class OtherActivity : BaseActivity<OtherViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        findViewById<TextView>(R.id.textView).text = viewModel?.number?.value.toString()
        findViewById<TextView>(R.id.plus).setOnClickListener {
            viewModel?.apply { number.value++ }
        }
        findViewById<TextView>(R.id.sub).setOnClickListener {
            viewModel?.apply { number.value-- }
        }
    }

    override fun bindViewModel(): OtherViewModel {
        return ViewModelProvider(this)[OtherViewModel::class.java]
    }
}