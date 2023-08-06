package com.example.intentsandlifecycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // writing log to track app workflow
        Log.d("Lifecycle", "Second Activity: onCreate() called")

        var counter = 0
        result = findViewById(R.id.tvResult)
        var btnCnt = findViewById<Button>(R.id.btnCounter)
        var tvCounter = findViewById<TextView>(R.id.tvCount)

        // onclicklistener to btn count
        btnCnt.setOnClickListener {
            counter += 1
            tvCounter.text = "" + counter
        }

        // getting values from main activity- put extra method into get extra method
        var userName: String = intent.getStringExtra("userName").toString()
        var userPhone: String = intent.getStringExtra("Phone number").toString()
        var userEmail: String = intent.getStringExtra("user Email").toString()
        var userAge: Int = intent.getIntExtra("userage", 10)

        result.text = "Hello, $userName \n\nYour phone number is: $userPhone, your email is $userEmail and your age is: $userAge."
    }

    // different lifecycle methods
    override fun onStart() {
        super.onStart()

        // writing log to track app workflow
        Log.d("Lifecycle", "Second Activity: onStart() called")
    }

    override fun onDestroy() {
        super.onDestroy()

        // writing log to track app workflow
        Log.d("Lifecycle", "Second Activity: onDestroy() called")
    }

    override fun onPause() {
        super.onPause()

        // writing log to track app workflow
        Log.d("Lifecycle", "Second Activity: onPause() called")
    }

    override fun onStop() {
        super.onStop()

        // writing log to track app workflow
        Log.d("Lifecycle", "Second Activity: onStop() called")
    }

    override fun onRestart() {
        super.onRestart()

        // writing log to track app workflow
        Log.d("Lifecycle", "Second Activity: onRestart() called")
    }

    override fun onResume() {
        super.onResume()

        // writing log to track app workflow
        Log.d("Lifecycle", "Second Activity: onResume() called")
    }
}