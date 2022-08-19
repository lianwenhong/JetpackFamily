package com.lianwenhong.jetpackfamily.ui

import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lianwenhong.jetpackfamily.R
import com.lianwenhong.jetpackfamily.ui.theme.JacketpackFamilyTheme

/**
 * 首页底部tab，目前没有用navigate啥的，先写个简单view
 */
@Composable
fun HomeBottomBar() {
    Row {
        for (i in 0 until 3) {
            BottomBarItem(i)
        }
    }
}

@Composable
fun BottomBarItem(index: Int) {
    when (index) {
        0 -> {
            Column() {
                Image(
                    painter = painterResource(id = R.mipmap.ic_launcher),
                    contentDescription = stringResource(id = R.string.tab_care)
                )
                Text(text = stringResource(id = R.string.tab_care))
            }
        }
        1 -> {
            Column() {
                Image(
                    painter = painterResource(id = R.mipmap.ic_launcher),
                    contentDescription = stringResource(id = R.string.tab_track)
                )
                Text(text = stringResource(id = R.string.tab_track))
            }
        }
        2 -> {
            Column() {
                Image(
                    painter = painterResource(id = R.mipmap.ic_launcher),
                    contentDescription = stringResource(id = R.string.tab_me)
                )
                Text(text = stringResource(id = R.string.tab_me))
            }
        }
    }

}