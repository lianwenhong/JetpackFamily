package com.lianwenhong.jetpackfamily.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lianwenhong.jetpackfamily.ui.theme.JacketpackFamilyTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JacketpackFamilyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(this, "SecondActivity")
                }
            }
        }
    }

    @Composable
    fun Greeting(context: Context, name: String) {
        Text(text = "Hello $name!", modifier = Modifier.clickable {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        })
    }
}
