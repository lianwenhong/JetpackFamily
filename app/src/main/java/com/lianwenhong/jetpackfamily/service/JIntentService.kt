package com.lianwenhong.jetpackfamily.service

import android.app.IntentService
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import com.lianwenhong.jetpackfamily.Const
import com.lianwenhong.jetpackfamily.util.SystemUtils

/**
 * IntentService和JobIntentService都已被弃用
 * 后续推荐使用androidx.work.WorkManager来代替
 */
class JIntentService(name: String?) : IntentService(name) {

    override fun onCreate() {
        super.onCreate()
        startForegroundNotification()
    }

    override fun onHandleIntent(intent: Intent?) {
    }

    private fun startForegroundNotification() {
        if (SystemUtils.isOverO8()) {
            val channel = NotificationChannel(
                packageName,
                Const.NOTIFICATION_CHANNEL_ID_J_INTENT,
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(NOTIFICATION_SERVICE)?.let { it as NotificationManager }
            manager?.createNotificationChannel(channel)
            val notification = Notification.Builder(
                this,
                packageName
            ).build()
            startForeground(Const.NOTIFICATION_ID_J_INTENT, notification)
        }
    }
}