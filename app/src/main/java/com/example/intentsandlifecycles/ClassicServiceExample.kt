package com.example.intentsandlifecycles

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ClassicServiceExample : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    // adding new functions manually
    override fun onCreate() {
        super.onCreate()

        Log.d("Service", "Classic Service Created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d("Service", "Classic Service Started")
        Log.d("Service Thread", Thread.currentThread().name)
        // manually stop/destroy classic service
        //        stopSelf()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("Service", "Classic Service Destroyed")
    }
}