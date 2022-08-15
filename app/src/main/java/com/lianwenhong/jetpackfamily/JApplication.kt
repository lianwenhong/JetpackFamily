package com.lianwenhong.jetpackfamily

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.lifecycle.ProcessLifecycleOwner
import com.lianwenhong.jetpackfamily.manager.AppManager
import com.lianwenhong.jetpackfamily.observer.AppLifecycleObserver

class JApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 通过lifecycle监测应用切换前后台操作
        ProcessLifecycleOwner.get().lifecycle.addObserver(AppLifecycleObserver())
        registerLifecycle()
    }

    fun getApp(): Application {
        return this
    }

    /**
     * 管理应用的页面（Activity）
     */
    private fun registerLifecycle() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                AppManager.addActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityResumed(activity: Activity) {
//                AppManager.getInstance().setCurrentActivity(activity)
            }

            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {
                AppManager.killActivity(activity)
            }
        })
    }
}