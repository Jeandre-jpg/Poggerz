package com.example.poggerz

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import java.lang.System.load


class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb)

        val loadMain = findViewById<ImageView>(R.id.gifImageView)
        val loadSecond = findViewById<ImageView>(R.id.gifImageView2)
        val buttonContainer = findViewById<LinearLayout>(R.id.buttonContainer)

        loadMain.startAnimation(ttb)
        loadSecond.startAnimation(ttb)
        buttonContainer.startAnimation(ttb)




        val timer: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(4000)
                } catch (e: InterruptedException) {
                    // TODO Auto-generated catch block
                    e.printStackTrace()
                } finally {
                    val i = Intent(this@LoadingActivity, AuthenticationActivity::class.java)
                    finish()
                    startActivity(i)
                }
            }
        }
        timer.start()
    }
}