package com.lianwenhong.jetpackfamily.observer

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.lianwenhong.jetpackfamily.util.LogUtils


/**
 *  Activity生命周期观察者
 *
 *  系统当前推荐2种观察者实现方式
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

/**
 * 方式1
 */
class ActivityLifecycleObserver : LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                LogUtils.d("${source.javaClass.simpleName} invoke onCreate")
            }
            Lifecycle.Event.ON_START -> {
                LogUtils.d("${source.javaClass.simpleName} invoke onStart")
            }
            Lifecycle.Event.ON_RESUME -> {
                LogUtils.d("${source.javaClass.simpleName} invoke onResume")
            }
            Lifecycle.Event.ON_PAUSE -> {
                LogUtils.d("${source.javaClass.simpleName} invoke onPause")
            }
            Lifecycle.Event.ON_STOP -> {
                LogUtils.d("${source.javaClass.simpleName} invoke onStop")
            }
            Lifecycle.Event.ON_DESTROY -> {
                LogUtils.d("${source.javaClass.simpleName} invoke onDestroy")
            }
            Lifecycle.Event.ON_ANY -> {
                LogUtils.d("${source.javaClass.simpleName} invoke other")
            }
        }
    }
}

/**
 * 方式2
 */
//class ActivityLifecycleObserver : DefaultLifecycleObserver {
//    override fun onCreate(owner: LifecycleOwner) {
//        LogUtils.d("${owner.javaClass.simpleName} invoke onCreate")
//    }
//
//    override fun onStart(owner: LifecycleOwner) {
//        LogUtils.d("${owner.javaClass.simpleName} invoke onStart")
//    }
//
//    override fun onResume(owner: LifecycleOwner) {
//        LogUtils.d("${owner.javaClass.simpleName} invoke onResume")
//    }
//
//    override fun onPause(owner: LifecycleOwner) {
//        LogUtils.d("${owner.javaClass.simpleName} invoke onPause")
//    }
//
//    override fun onStop(owner: LifecycleOwner) {
//        LogUtils.d("${owner.javaClass.simpleName} invoke onStop")
//    }
//
//    override fun onDestroy(owner: LifecycleOwner) {
//        LogUtils.d("${owner.javaClass.simpleName} invoke onDestroy")
//    }
//}

/**
 * 两种方式都实现
 */
//class ActivityLifecycleObserver : DefaultLifecycleObserver, LifecycleEventObserver {
//    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
//        when (event) {
//            Lifecycle.Event.ON_CREATE -> {
//                LogUtils.d("${source.javaClass.simpleName} invoke onCreate in onStateChanged")
//            }
//            Lifecycle.Event.ON_START -> {
//                LogUtils.d("${source.javaClass.simpleName} invoke onStart in onStateChanged")
//            }
//            Lifecycle.Event.ON_RESUME -> {
//                LogUtils.d("${source.javaClass.simpleName} invoke onResume in onStateChanged")
//            }
//            Lifecycle.Event.ON_PAUSE -> {
//                LogUtils.d("${source.javaClass.simpleName} invoke onPause in onStateChanged")
//            }
//            Lifecycle.Event.ON_STOP -> {
//                LogUtils.d("${source.javaClass.simpleName} invoke onStop in onStateChanged")
//            }
//            Lifecycle.Event.ON_DESTROY -> {
//                LogUtils.d("${source.javaClass.simpleName} invoke onDestroy in onStateChanged")
//            }
//            Lifecycle.Event.ON_ANY -> {
//                LogUtils.d("${source.javaClass.simpleName} invoke other in onStateChanged")
//            }
//        }
//    }
//
//    override fun onCreate(owner: LifecycleOwner) {
//        LogUtils.d("${owner.javaClass.simpleName} invoke onCreate in DefaultLifecycleObserver callback")
//    }
//
//    override fun onStart(owner: LifecycleOwner) {
//        LogUtils.d("${owner.javaClass.simpleName} invoke onStart in DefaultLifecycleObserver callback")
//    }
//
//    override fun onResume(owner: LifecycleOwner) {
//        LogUtils.d("${owner.javaClass.simpleName} invoke onResume in DefaultLifecycleObserver callback")
//    }
//
//    override fun onPause(owner: LifecycleOwner) {
//        LogUtils.d("${owner.javaClass.simpleName} invoke onPause in DefaultLifecycleObserver callback")
//    }
//
//    override fun onStop(owner: LifecycleOwner) {
//        LogUtils.d("${owner.javaClass.simpleName} invoke onStop in DefaultLifecycleObserver callback")
//    }
//
//    override fun onDestroy(owner: LifecycleOwner) {
//        LogUtils.d("${owner.javaClass.simpleName} invoke onDestroy in DefaultLifecycleObserver callback")
//    }
//}