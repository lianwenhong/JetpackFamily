package com.lianwenhong.jetpackfamily.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.lianwenhong.jetpackfamily.ui.theme.JacketpackFamilyTheme
import com.lianwenhong.jetpackfamily.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JacketpackFamilyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LifecycleView(context = this, viewModel = viewModel)
                }
            }
        }
    }

    override fun bindViewModel(): MainViewModel {
        // 看不懂这语法
        return ViewModelProvider(this)[MainViewModel::class.java]
    }

    /**
     * 屏幕旋转，配置改变
     */
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
}



