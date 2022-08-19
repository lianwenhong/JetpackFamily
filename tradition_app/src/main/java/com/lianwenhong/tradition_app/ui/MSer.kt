package com.lianwenhong.tradition_app.ui

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.view.LayoutInflater

class MSer: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        LayoutInflater.from(this)
        return null
    }
}