package com.prashant.splashsscreen

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.util.Pair


class SpalshActivity_eleven : AppCompatActivity() {

    private val splashDelay: Long = 2000 // 2 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spalsh_eleven)
        val logoView: View = findViewById(R.id.logoImage)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, SpalshActivity_ten::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(
                this,
                Pair(logoView, "logoTransition")
            )
            startActivity(intent, options.toBundle())
            finish()
        }, splashDelay)
    }


}