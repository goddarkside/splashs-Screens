package com.prashant.splashsscreen

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewTreeObserver
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.hypot

class SpalshActivity_thirteen : AppCompatActivity() {

    private lateinit var rootLayout: View
    private lateinit var logoImageView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spalsh_thirteen)

        rootLayout = findViewById(R.id.root_layout)
        logoImageView = findViewById(R.id.logoImageView)

        rootLayout.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                rootLayout.viewTreeObserver.removeOnPreDrawListener(this)
                startRevealAnimation()
                return true
            }
        })
    }

    private fun startRevealAnimation() {
        val cx = rootLayout.width / 2
        val cy = rootLayout.height / 2
        val finalRadius = hypot(cx.toDouble(), cy.toDouble()).toFloat()

        val anim = ViewAnimationUtils.createCircularReveal(rootLayout, cx, cy, 0f, finalRadius)
        rootLayout.visibility = View.VISIBLE
        anim.duration = 1000
        anim.start()

        anim.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                logoImageView.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animator) {
                Handler().postDelayed({
                    startActivity(Intent(this@SpalshActivity_thirteen, SpalshActivity_twelve::class.java))
                    finish()
                }, 1500)
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
    }
}