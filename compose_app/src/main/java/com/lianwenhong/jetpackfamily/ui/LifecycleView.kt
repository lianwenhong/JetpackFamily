package com.lianwenhong.jetpackfamily.ui

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lianwenhong.jetpackfamily.R
import com.lianwenhong.jetpackfamily.service.JOriginalService
import com.lianwenhong.jetpackfamily.util.ContextUtils
import com.lianwenhong.jetpackfamily.viewmodel.MainViewModel

@Composable
fun LifecycleView(context: Context, viewModel: MainViewModel?) {
    val intent = Intent(context, JOriginalService::class.java)
    Column() {
        Text(
            text = "基础Lifecycle",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,//加粗
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(alignment = Alignment.CenterHorizontally)
                .padding(5.dp)
        )
        Spacer(
            Modifier
                .background(MaterialTheme.colorScheme.onBackground)
                .fillMaxWidth()
                .height(0.5.dp)
                .padding(horizontal = 0.dp, vertical = 4.dp)
        )
        Text(
            text = "Start Service",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(alignment = Alignment.CenterHorizontally)
                .padding(5.dp)
                .clickable {
                    ContextUtils.startService(context, intent)
                })
        Text(text = "Stop Service",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(alignment = Alignment.CenterHorizontally)
                .padding(5.dp)
                .clickable {
                    context.stopService(intent)
                })
        Spacer(
            Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .fillMaxWidth()
                .height(3.dp)
                .padding(horizontal = 0.dp, vertical = 4.dp)
        )
        Text(
            text = "基础ViewModel${viewModel?.mutableNumber?.value}-${viewModel?.number}",
            fontWeight = FontWeight.Bold,//加粗
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(alignment = Alignment.CenterHorizontally)
                .padding(5.dp)
        )
        Spacer(
            Modifier
                .background(MaterialTheme.colorScheme.onBackground)
                .fillMaxWidth()
                .height(0.5.dp)
                .padding(horizontal = 0.dp, vertical = 4.dp)
        )
        Text(
            text = stringResource(R.string.plus),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(alignment = Alignment.CenterHorizontally)
                .padding(5.dp)
                .clickable {
                    viewModel?.apply {
                        mutableNumber.value++
                        number++
                    }
//                    LogUtils.d(viewModel?.number.toString())
                })
        Text(
            text = stringResource(R.string.subtraction),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(alignment = Alignment.CenterHorizontally)
                .padding(5.dp)
                .clickable {
                    viewModel?.apply {
                        mutableNumber.value--
                        number--
                    }
//                    LogUtils.d(viewModel?.number.toString())
                })
        Spacer(
            Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .fillMaxWidth()
                .height(3.dp)
                .padding(horizontal = 0.dp, vertical = 4.dp)
        )
    }
}