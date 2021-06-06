package com.example.poggerz

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.poggerz.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"

    var NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb)

        val logo_app = findViewById<ImageView>(R.id.logo_app)
        val buttonContainer = findViewById<LinearLayout>(R.id.buttonContainer)

        logo_app.startAnimation(ttb)
        buttonContainer.startAnimation(ttb)



        createNotificationChannel()

        val intent = Intent(this, LoadingActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        //    NOTIFICATION_ID = Random.nextInt()

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Welcome to Poggerz!")
                .setContentText("The entire team of Poggerz is thrilled to welcome you on board. We hope you’ll enjoy all things Gorillaz on our app!")
                .setSmallIcon(R.drawable.logo)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build()

        val notificationManager = NotificationManagerCompat.from(this)


        start_btn.setOnClickListener{
            notificationManager.notify(NOTIFICATION_ID, notification)
            startActivity(Intent(this, LoadingActivity::class.java))
        }
    }

    fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH).apply {
                enableLights(true)
                lightColor = Color.YELLOW
            }

            val manager =  getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)

        }
    }

}

