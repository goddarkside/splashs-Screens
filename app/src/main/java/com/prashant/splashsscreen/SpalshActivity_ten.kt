package com.prashant.splashsscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class SpalshActivity_ten : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var sliderAdapter: SliderAdapter
    private val handler = Handler(Looper.getMainLooper())
    private var currentPage = 0
    private val images = listOf(
        R.drawable.slied1,
        R.drawable.slied2,
        R.drawable.slied3
    )

    private val autoSlideRunnable = object : Runnable {
        override fun run() {
            if (currentPage < images.size - 1) {
                currentPage++
                viewPager.setCurrentItem(currentPage, true)
                handler.postDelayed(this, 2000)
            } else {
                startActivity(Intent(this@SpalshActivity_ten, SpalshActivity_nine::class.java))
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spalsh_ten)

        viewPager = findViewById(R.id.viewPager)
        sliderAdapter = SliderAdapter(images)
        viewPager.adapter = sliderAdapter

        handler.postDelayed(autoSlideRunnable, 2000)

    }
    override fun onDestroy() {
        handler.removeCallbacks(autoSlideRunnable)
        super.onDestroy()
    }
}