package com.lianwenhong.jetpackfamily.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ServiceLifecycleDispatcher
import com.lianwenhong.jetpackfamily.observer.ActivityLifecycleObserver
import com.lianwenhong.jetpackfamily.service.JOriginalService
import com.lianwenhong.jetpackfamily.ui.theme.JacketpackFamilyTheme
import com.lianwenhong.jetpackfamily.util.ContextUtils
import com.lianwenhong.jetpackfamily.util.LogUtils
import com.lianwenhong.jetpackfamily.viewmodel.ActivityViewModel
import com.lianwenhong.jetpackfamily.viewmodel.MainViewModel


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JacketpackFamilyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(this, "Android")
                }
            }
        }
    }

    override fun bindViewModel(): ActivityViewModel {
        return MainViewModel(lifecycle)
    }

}

@Composable
fun Greeting(context: Context, name: String) {
    val intent = Intent(context, JOriginalService::class.java)
    Column() {
        Text(text = "Hello $name!", modifier = Modifier.clickable {
//        val intent = Intent(context, SecondActivity::class.java)
//        context.startActivity(intent)
            ContextUtils.startService(context, intent)
        })
        Spacer(
            Modifier
                .background(Color.Gray)
                .fillMaxWidth()
                .height(5.dp)
                .padding(horizontal = 0.dp, vertical = 4.dp)
        )

        Text(text = "Hello $name!", modifier = Modifier.clickable {
//        val intent = Intent(context, SecondActivity::class.java)
//        context.startActivity(intent)

            context.stopService(intent)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JacketpackFamilyTheme {
        Greeting(null!!, "Android")
    }
}