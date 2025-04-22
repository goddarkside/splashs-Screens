package com.prashant.splashsscreen

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SpalshActivity_twelve : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spalsh_twelve)

        // Initialize and play sound
        mediaPlayer = MediaPlayer.create(this, R.raw.splash_sound)
        mediaPlayer.start()

        // Navigate to main activity after 3 seconds
        Handler().postDelayed({
            mediaPlayer.release()
            startActivity(Intent(this, SpalshActivity_eleven::class.java))
            finish()
        }, 3000)
    }
    override fun onDestroy() {
        super.onDestroy()

        if (::mediaPlayer.isInitialized) {
            try {
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.stop()
                }
                mediaPlayer.release()
            } catch (e: IllegalStateException) {
                e.printStackTrace()
            }
        }
    }
}