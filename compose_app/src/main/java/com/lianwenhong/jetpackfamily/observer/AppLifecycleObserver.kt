package com.lianwenhong.jetpackfamily.observer

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.lianwenhong.jetpackfamily.util.LogUtils

/**
 *  应用切换前后台监听类
 *
 *  系统提供2种观察者实现方式
 *  1.实现LifecycleEventObserver，当生命周期发生变化时系统会回调到LifecycleEventObserver->onStateChanged方法中
 *  2.继承DefaultLifecycleObserver，系统已经为每一种生命周期声明了对应的方法，当生命周期发生变化时会回调到相应方法中
 *
 *  注意：
 *  开发者可任意实现其中一种或者两种都实现
 *  当开发者的观察者两种方式都实现，会先回调到DefaultLifecycleObserver对应的方法，然后再回调到LifecycleEventObserver->onStateChanged
 *
 *  另外还有一种观察者是实现LifecycleObserver接口并通过@OnLifecycleEvent(Lifecycle.Event.ON_XXX)注解来标识生命周期方法的方式已经被弃用了
 *  因为@OnLifecycleEvent是个运行时注解，实现监听过程是通过反射生成中间代码来实现的，影响应用性能所以被官方抛弃了
 */

/*
方式1，实现LifecycleEventObserver接口
 */
class AppLifecycleObserver : LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_RESUME -> {
                LogUtils.d("当前应用处于前台")
            }
            Lifecycle.Event.ON_STOP -> {
                LogUtils.d("当前应用处于后台")
            }
            Lifecycle.Event.ON_CREATE,
            Lifecycle.Event.ON_START,
            Lifecycle.Event.ON_PAUSE,
            Lifecycle.Event.ON_DESTROY,
            Lifecycle.Event.ON_ANY
            -> {
            }
        }
    }
}

/*
方式2，继承DefaultLifecycleObserver观察者，该类中为每一种生命周期状态声明了对应方法，只需实现即可
 */
//class AppLifecycleObserver : DefaultLifecycleObserver {
//    override fun onResume(owner: LifecycleOwner) {
//        LogUtils.d("当前应用处于前台")
//    }
//
//    override fun onStop(owner: LifecycleOwner) {
//        LogUtils.d("当前应用处于后台")
//    }
//}

/*
两种方式都实现
 */
//class AppLifecycleObserver : DefaultLifecycleObserver, LifecycleEventObserver {
//
//    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
//        when (event) {
//            Lifecycle.Event.ON_RESUME -> {
//                LogUtils.d("方式1 --- 当前应用处于前台")
//            }
//            Lifecycle.Event.ON_STOP -> {
//                LogUtils.d("方式1 --- 当前应用处于后台")
//            }
//            Lifecycle.Event.ON_CREATE,
//            Lifecycle.Event.ON_START,
//            Lifecycle.Event.ON_PAUSE,
//            Lifecycle.Event.ON_DESTROY,
//            Lifecycle.Event.ON_ANY
//            -> {
//            }
//        }
//    }
//
//    override fun onResume(owner: LifecycleOwner) {
//        LogUtils.d("方式2 --- 当前应用处于前台")
//    }
//
//    override fun onStop(owner: LifecycleOwner) {
//        LogUtils.d("方式2 --- 当前应用处于后台")
//    }
//
//}