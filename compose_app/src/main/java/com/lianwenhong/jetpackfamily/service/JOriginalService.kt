package com.lianwenhong.jetpackfamily.service

import android.content.Intent
import android.os.IBinder
import com.lianwenhong.jetpackfamily.Const
import com.lianwenhong.jetpackfamily.observer.ServiceLifecycleObserver

class JOriginalService : JService() {
    override fun onCreate() {
        startForegroundNotification(
            Const.NOTIFICATION_CHANNEL_ID_J_INTENT,
            Const.NOTIFICATION_ID_J_INTENT
        )
        lifecycle.addObserver(ServiceLifecycleObserver())
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        super.onBind(intent)
        // 这样就可以即实现生命周期，又可以使用自己的逻辑
        return null
    }

}