package com.prashant.splashsscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity_five : AppCompatActivity() {

    private val splashDuration: Long = 3000 // 3 seconds
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_five)

        // Delay and then start MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, Splash_Activity_four::class.java))
            finish()
        }, splashDuration)

    }
}