package com.prashant.splashsscreen.OnboardingFiles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.prashant.splashsscreen.MainActivity
import com.prashant.splashsscreen.R
import com.prashant.splashsscreen.SpalshActivity_eight

class OnboardingActivity : AppCompatActivity() {


    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: OnboardingAdapter
    private lateinit var finishButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewPager)
        finishButton = findViewById(R.id.finishButton)

        val pages = listOf(
            OnboardingPage("Welcome", "This is your new favorite app!", R.drawable.baseline_fire_hydrant_alt_24),
            OnboardingPage("Features", "Explore powerful features.", R.drawable.baseline_panorama_horizontal_select_24),
            OnboardingPage("Get Started", "Let's dive in!", R.drawable.logo)
        )

        adapter = OnboardingAdapter(pages)
        viewPager.adapter = adapter

        finishButton.setOnClickListener {
            val prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            prefs.edit().putBoolean("onboarding_complete", false).apply() // this value will be true after the first launch
            startActivity(Intent(this, SpalshActivity_eight::class.java))
            finish()
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                finishButton.visibility = if (position == pages.lastIndex) Button.VISIBLE else Button.GONE
            }
        })

    }
}