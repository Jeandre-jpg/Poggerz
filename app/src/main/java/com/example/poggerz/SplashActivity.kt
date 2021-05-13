package com.example.poggerz

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.poggerz.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb)

        val logo_app = findViewById(R.id.logo_app) as ImageView
        val buttonContainer = findViewById(R.id.buttonContainer) as LinearLayout

        logo_app.startAnimation(ttb)
        buttonContainer.startAnimation(ttb)

        start_btn.setOnClickListener {
            startActivity(Intent(this, LoadingActivity::class.java))
        }
    }
}