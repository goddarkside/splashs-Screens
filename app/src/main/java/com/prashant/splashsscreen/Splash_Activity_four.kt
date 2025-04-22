package com.prashant.splashsscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class Splash_Activity_four : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_four)

        val gifImageView = findViewById<ImageView>(R.id.gifImageView)

        Glide.with(this)
            .asGif()
            .load(R.raw.gif_logo) // put your .gif file in res/drawable
            .into(gifImageView)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, Splash_Activity_Three::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, 4000)

    }
}