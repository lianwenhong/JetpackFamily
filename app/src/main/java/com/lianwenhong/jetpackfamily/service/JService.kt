package com.lianwenhong.jetpackfamily.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import androidx.lifecycle.LifecycleService
import com.lianwenhong.jetpackfamily.util.SystemUtils

/**
 * 后来发现这个类实际上Android系统已经提供了一个一模一样的类：LifecycleService
 * 所以此处将生命周期相关代码注释并且直接继承LifecycleService
 */
abstract class JService : LifecycleService() /*Service(), LifecycleOwner*/ {

    fun startForegroundNotification(channelId: String, notificationId: Int) {
        if (SystemUtils.isOverO8()) {
            val channel = NotificationChannel(
                packageName,
                channelId,
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(NOTIFICATION_SERVICE)?.let { it as NotificationManager }
            manager?.createNotificationChannel(channel)
            val notification = Notification.Builder(
                this,
                packageName
            ).build()
            startForeground(notificationId, notification)
        }
    }

//    private val mDispatcher: ServiceLifecycleDispatcher = ServiceLifecycleDispatcher(this)
//
//    override fun getLifecycle(): Lifecycle {
//        return mDispatcher.lifecycle
//    }
//
//    fun onServicePreSuperOnCreate() {
//        mDispatcher.onServicePreSuperOnCreate()
//    }
//
//    fun onServicePreSuperOnStart() {
//        mDispatcher.onServicePreSuperOnStart()
//    }
//
//    fun onServicePreSuperOnBind() {
//        mDispatcher.onServicePreSuperOnBind()
//    }
//
//    fun onServicePreSuperOnDestroy() {
//        mDispatcher.onServicePreSuperOnDestroy()
//    }
}