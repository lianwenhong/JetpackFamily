package com.lianwenhong.jetpackfamily.manager

import android.app.Activity
import android.os.Process
import java.lang.ref.WeakReference
import java.util.*
import kotlin.system.exitProcess

object AppManager {

    private val lock: Any = Any()

    /**
     * 应用中打开的Activity页面集合，排序规则为：index 0为最新页面，index size-1为最早页面
     */
    private val activities: ArrayList<Activity> = arrayListOf()
    private var curActivity: WeakReference<Activity>? = null

    /**
     * 添加最新页面
     */
    fun addActivity(act: Activity) {
        synchronized(lock) {
            activities.add(0, act)
            curActivity = WeakReference(act)
        }
    }

    /**
     * 获取当前栈顶页面
     */
    fun currentActivity(): Activity? {
        synchronized(lock) {
            return curActivity?.get()
        }
    }

    /**
     * 判断某个页面是否还未被销毁
     * 返回值为页面索引，如果索引为-1则表示页面已销毁
     */
    fun isActivityLive(activity: Activity): Int {
        synchronized(lock) {
            return activities.indexOf(activity)
        }
    }

    /**
     * 移除页面
     */
    fun killActivity(act: Activity) {
        synchronized(lock) {
            if (activities.isEmpty())
                return
            activities.remove(act)
        }
    }

    /**
     * 关闭某个页面
     */
    fun killActivity(activityClz: Class<*>) {
        synchronized(lock) {
            if (activities.isEmpty())
                return
            activities.forEach {
                if (it.javaClass == activityClz) {
                    it.finish()
                    activities.remove(it)
                    return
                }
            }
        }
    }

    private fun killAll() {
        synchronized(lock) {
            activities.forEach {
                it.finish()
            }
        }
    }

    /**
     * 退出应用程序
     *
     * 此方法经测试在某些机型上并不能完全杀死 App 进程, 几乎试过市面上大部分杀死进程的方式, 但都发现没卵用, 所以此
     * 方法如果不能百分之百保证能杀死进程, 就不能贸然调用 [.release] 释放资源, 否则会造成其他问题, 如果您
     * 有测试通过的并能适用于绝大多数机型的杀死进程的方式, 望告知
     */
    fun appExit() {
        try {
            killAll()
            Process.killProcess(Process.myPid())
            exitProcess(0)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}