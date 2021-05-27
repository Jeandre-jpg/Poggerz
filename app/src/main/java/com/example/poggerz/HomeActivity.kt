package com.example.poggerz

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.replace
import com.example.poggerz.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//
//        val homeFragment = HomeActivity()
//
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fl_fragment, homeFragment)
//            commit()
//        }
//
//        //Make the View FullScreen
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
//
//        wp_back_btn.setOnClickListener {
//            val intent = Intent(this, ChatActivity::class.java)
//            startActivity(intent)
//        }
//    }
}