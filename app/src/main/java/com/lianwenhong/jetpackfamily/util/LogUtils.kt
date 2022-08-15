package com.lianwenhong.jetpackfamily.util

import android.util.Log

class LogUtils {
    companion object {
        fun d(msg: String?): Unit {
            msg?.let {
                Log.d("JectpackFamily", " >>> $msg <<<")
            }
        }
    }
}