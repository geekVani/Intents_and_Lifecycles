package com.example.intentsandlifecycles

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class JobIntentServiceExample : JobIntentService() {
    override fun onHandleWork(intent: Intent) {
        Log.d("Service", "Job Intent Service started")
        Log.d("Service", Thread.currentThread().name) // thread log record
    }

    companion object{
        // new function for bckground service
        fun myBackgroundService(context: Context, intent: Intent){
            enqueueWork(context, JobIntentServiceExample::class.java, 1, intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Service", "Job Intent Service Destroyed")
    }
}