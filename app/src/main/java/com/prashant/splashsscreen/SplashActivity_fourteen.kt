package com.prashant.splashsscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity_fourteen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_fourteen)

        val logoImage = findViewById<View>(R.id.logoImage)
        val taglineText = findViewById<View>(R.id.taglineText)

        // Fade-in animation
        val fadeIn = AlphaAnimation(0f, 1f).apply {
            duration = 1000
            fillAfter = true
        }

        // Fade-out animation
        val fadeOut = AlphaAnimation(1f, 0f).apply {
            duration = 1000
            startOffset = 2500
            fillAfter = true
        }

        logoImage.visibility = View.VISIBLE
        taglineText.visibility = View.VISIBLE

        logoImage.startAnimation(fadeIn)
        taglineText.startAnimation(fadeIn)

        Handler(Looper.getMainLooper()).postDelayed({
            logoImage.startAnimation(fadeOut)
            taglineText.startAnimation(fadeOut)
        }, 2500)

        // Navigate to MainActivity after fade out
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, SpalshActivity_thirteen::class.java))
            finish()
        }, 3500)
    }
}