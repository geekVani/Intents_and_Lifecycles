package com.example.intentsandlifecycles


/* **********************************
* Only works for devices with API level 25 or earlier
* Use Manifest file for receiver
************************************* */
import android.app.ProgressDialog.show
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastExample : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        // not null assert : !!
        val isAirplaneMode : Boolean = intent!!.getBooleanExtra("state", false)

        // showing toast when airplane mode is on or off
        if(isAirplaneMode){
            Toast.makeText(context, "Airplane mode is ON.", Toast.LENGTH_LONG)
                .show()
        }
        else{
            Toast.makeText(context, "Airplane mode is OFF.", Toast.LENGTH_LONG)
                .show()
        }

    }
}