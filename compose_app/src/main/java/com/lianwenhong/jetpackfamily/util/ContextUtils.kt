package com.lianwenhong.jetpackfamily.util

import android.content.Context
import android.content.Intent

object ContextUtils {
    fun startService(context: Context, intent: Intent) {
        if (SystemUtils.isOverO8()) {
            context.startForegroundService(intent)
        } else {
            context.startService(intent)
        }
    }
}