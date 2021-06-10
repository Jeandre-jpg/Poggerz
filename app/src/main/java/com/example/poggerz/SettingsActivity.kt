package com.example.poggerz

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.poggerz.fragments.SettingsFragment

class SettingsActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_profile)

        val settingsFragment = SettingsFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, settingsFragment)
            commit()
        }

        //Make the View FullScreen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

//        wp_back_btn.setOnClickListener {
//            val intent = Intent(this, ChatActivity::class.java)
//            startActivity(intent)
//        }
    }
}