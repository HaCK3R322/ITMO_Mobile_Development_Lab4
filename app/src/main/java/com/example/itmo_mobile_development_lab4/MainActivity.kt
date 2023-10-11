package com.example.itmo_mobile_development_lab4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private var serviceStarted: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.startButton).setOnClickListener{
            startPlayerService()
        }

        findViewById<Button>(R.id.stopButton).setOnClickListener{
            stopPlayerService()
        }
    }

    private fun startPlayerService() {
        if(!serviceStarted) {
            startService(Intent(this, PlayerService::class.java))
            serviceStarted = true
        }
    }

    private fun stopPlayerService() {
        if(serviceStarted) {
            stopService(Intent(this, PlayerService::class.java))
            serviceStarted = false
        }

    }
}