package com.prashant.splashsscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.prashant.splashsscreen.OnboardingFiles.OnboardingActivity

class SpalshActivity_nine : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spalsh_nine)

        val prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val hasSeenOnboarding = prefs.getBoolean("onboarding_complete", false)

        Handler(Looper.getMainLooper()).postDelayed({
            if (hasSeenOnboarding) {
                startActivity(Intent(this, SpalshActivity_eight::class.java))
            } else {
                startActivity(Intent(this, OnboardingActivity::class.java))
            }
            finish()
        }, 2000)
    }
}