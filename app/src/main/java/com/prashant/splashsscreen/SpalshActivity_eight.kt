package com.prashant.splashsscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.ScaleAnimation
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SpalshActivity_eight : AppCompatActivity() {

    private lateinit var counterText: TextView
    private var count = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spalsh_eight)


        counterText = findViewById(R.id.counter)

        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                if (count > 0) {
                    counterText.text = count.toString()
                    val scaleAnim = ScaleAnimation(
                        0.5f, 1f,   // from X scale to X scale
                        0.5f, 1f,   // from Y scale to Y scale
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                    )
                    scaleAnim.interpolator = BounceInterpolator()
                    scaleAnim.duration = 300
//                    scaleAnim.interpolator = DecelerateInterpolator()
                    counterText.startAnimation(scaleAnim)

                    count--
                    handler.postDelayed(this, 1000)
                } else {
                    // Launch your next activity
                    startActivity(Intent(this@SpalshActivity_eight, Splash_Activity_Seven::class.java))
                    finish()
                }
            }
        }
        handler.post(runnable)
    }
}