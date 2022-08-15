package com.lianwenhong.jetpackfamily.util

import android.os.Build

object SystemUtils {
    fun isOverL5(): Boolean {
        // Build.VERSION_CODES.LOLLIPOP
        return Build.VERSION.SDK_INT >= 21
    }

    fun isOverM6(): Boolean {
        // Build.VERSION_CODES.M
        return Build.VERSION.SDK_INT >= 23
    }

    fun isOverN7(): Boolean {
        // Build.VERSION_CODES.N
        return Build.VERSION.SDK_INT >= 24
    }

    fun isOverN7_1(): Boolean {
        // Build.VERSION_CODES.N_MR1
        return Build.VERSION.SDK_INT >= 25
    }

    fun isOverO8(): Boolean {
        // Build.VERSION_CODES.O
        return Build.VERSION.SDK_INT >= 26
    }

    fun isOverO8_1(): Boolean {
        // Build.VERSION_CODES.O_MR1
        return Build.VERSION.SDK_INT >= 27
    }

    fun isOverP9(): Boolean {
        // Build.VERSION_CODES.P
        return Build.VERSION.SDK_INT >= 28
    }

    fun isOverQ10(): Boolean {
        // Build.VERSION_CODES.Q
        return Build.VERSION.SDK_INT >= 29
    }

    fun isOverR11(): Boolean {
        // Build.VERSION_CODES.R
        return Build.VERSION.SDK_INT >= 30
    }

    fun isOverS12(): Boolean {
        // Build.VERSION_CODES.S
        return Build.VERSION.SDK_INT >= 31
    }

    fun getOSRelease(): String? {
        return Build.VERSION.RELEASE
    }
}