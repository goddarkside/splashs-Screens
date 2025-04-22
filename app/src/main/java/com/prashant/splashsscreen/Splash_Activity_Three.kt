package com.prashant.splashsscreen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Splash_Activity_Three : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_three)
        val videoView = findViewById<VideoView>(R.id.videoView)

        val videoPath = "android.resource://${packageName}/${R.raw.logo_video}"
        val uri = Uri.parse(videoPath)
        videoView.setVideoURI(uri)

        videoView.setOnCompletionListener {
            startActivity(Intent(this, Splash_Activity_one::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }

        videoView.start()

    }
}