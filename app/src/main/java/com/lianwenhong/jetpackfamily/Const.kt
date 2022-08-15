package com.lianwenhong.jetpackfamily

interface Const {

    companion object {
        const val NOTIFICATION_CHANNEL_ID_J_ORIGINAL: String = "JIntentService"
        const val NOTIFICATION_CHANNEL_ID_J_INTENT: String = "JOriginalService"

        const val NOTIFICATION_ID_J_ORIGINAL: Int = 0x01
        const val NOTIFICATION_ID_J_INTENT: Int = 0x02

    }
}