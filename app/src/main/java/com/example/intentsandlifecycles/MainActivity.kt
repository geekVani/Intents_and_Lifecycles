/********************************************************************* *
* Intents in Android
* Application Lifecycle
* Activity Lifecycle
* Fragment Lifecycle
* Services: Background --> Classic & Job intent
* Receivers: Broadcast (for API 25 or lower) & Context (for all API)
* View Binding: Replace findViewById()
* ******************************************************************** */

package com.example.intentsandlifecycles

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var phone: EditText
    lateinit var email: EditText
    lateinit var age: EditText
    lateinit var send: Button
    lateinit var service: Button // services
    lateinit var binding: Button // view binding
    var bcr = BroadcastExample()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.etName)
        phone = findViewById(R.id.etPhone)
        email = findViewById(R.id.etEmail)
        age = findViewById(R.id.etAge)
        send = findViewById(R.id.btnSubmit)
        service = findViewById(R.id.btnService)
        binding = findViewById(R.id.btnView)

        // writing log to track app workflow
        Log.d("Lifecycle", "Main Activity: onCreate() called")

        // broadcast/context receiver for all API levels
        /*
        * No need for manifest file
        * Declare in onStart() and onStop() method
        * so it stops on closing application
        * */
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        this.registerReceiver(bcr, filter)

        send.setOnClickListener {

            // assign values inputted by user to variables
            val userName: String = name.text.toString()
            val userPhone: String = phone.text.toString()
            val userEmail: String = email.text.toString()
            val userAge: Int = age.text.toString().toInt()

            val intent = Intent(this, SecondActivity::class.java)

            // using variables in second activity
            intent.putExtra("userName",userName)
            intent.putExtra("Phone number",userPhone)
            intent.putExtra("user Email",userEmail)
            intent.putExtra("userage",userAge)

            // calling intent
            startActivity(intent)
        }

        service.setOnClickListener {
            var i = Intent(this, ServiceActivity::class.java)
            startActivity(i)
        }

        binding.setOnClickListener {
            var intent = Intent(this, ViewBinding::class.java)
            startActivity(intent)
        }

    }

    // different lifecycle methods
    override fun onStart() {
        super.onStart()

        // writing log to track app workflow
        Log.d("Lifecycle", "Main Activity: onStart() called")

        // context receiver toast only when app is running
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        this.registerReceiver(bcr, filter)
    }

    override fun onDestroy() {
        super.onDestroy()

        // writing log to track app workflow
        Log.d("Lifecycle", "Main Activity: onDestroy() called")
    }

    override fun onPause() {
        super.onPause()

        // writing log to track app workflow
        Log.d("Lifecycle", "Main Activity: onPause() called")
    }

    override fun onStop() {
        super.onStop()

        // writing log to track app workflow
        Log.d("Lifecycle", "Main Activity: onStop() called")

        // context receiver toast invisible on closing application
        this.unregisterReceiver(bcr)
    }

    override fun onRestart() {
        super.onRestart()

        // writing log to track app workflow
        Log.d("Lifecycle", "Main Activity: onRestart() called")
    }

    override fun onResume() {
        super.onResume()

        // writing log to track app workflow
        Log.d("Lifecycle", "Main Activity: onResume() called")
    }
}