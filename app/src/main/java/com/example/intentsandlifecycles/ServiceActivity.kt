package com.example.intentsandlifecycles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ServiceActivity : AppCompatActivity() {

    lateinit var startClassicService: Button
    lateinit var startJobIntentService: Button
    lateinit var stopClassicService: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        startClassicService = findViewById(R.id.btnStartClassic)
        startJobIntentService = findViewById(R.id.btnJobIntent)
        stopClassicService = findViewById(R.id.btnJobIntent)

        startClassicService.setOnClickListener {

            val intent = Intent(this@ServiceActivity, ClassicServiceExample::class.java)
            startService(intent)

        }

        startJobIntentService.setOnClickListener {

            val intent1 = Intent(this@ServiceActivity, JobIntentServiceExample::class.java)
            JobIntentServiceExample.myBackgroundService(this@ServiceActivity, intent1)
        }

        stopClassicService.setOnClickListener {
            val intent2 = Intent(this@ServiceActivity, ClassicServiceExample::class.java)
            stopService(intent2)

        }


    }
}