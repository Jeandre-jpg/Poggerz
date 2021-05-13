package com.example.poggerz

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_loading.*


class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb)

        val load = findViewById(R.id.load) as ImageView
        val buttonContainer = findViewById(R.id.buttonContainer) as LinearLayout

        load.startAnimation(ttb)
        buttonContainer.startAnimation(ttb)


        start_btn.setOnClickListener {
            startActivity(Intent(this, AuthenticationActivity::class.java))
        }
    }
}