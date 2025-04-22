package com.prashant.splashsscreen

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity_Six : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_six)

        val layout = findViewById<LinearLayout>(R.id.rootLayout)
        layout.setBackgroundResource(R.drawable.gradient_animation_1)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, SplashActivity_five::class.java))
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            finish()
        }, 4000)

    }

    override fun onStart() {
        super.onStart()
        val layout = findViewById<LinearLayout>(R.id.rootLayout)
        layout.setBackgroundResource(R.drawable.gradient_animation_1)
        val animationDrawable = layout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(1000)
        animationDrawable.setExitFadeDuration(1000)
        animationDrawable.start()
    }

}