package com.example.poggerz

import android.accounts.Account
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.poggerz.fragments.ChatsFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.android.material.navigation.NavigationView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_chats.*
import java.io.ByteArrayOutputStream
import java.util.*

class ChatActivity : AppCompatActivity() {

    private lateinit var drawer: DrawerLayout

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chats)

        //Reference the Chats and Search Fragments
        val chatsFragment = ChatsFragment()

        //Set the default fragment view to ChatsFragment
        supportFragmentManager.beginTransaction().apply {
            fl_fragment_chats.setBackgroundResource(R.drawable.gorillaz_camo_pattern_full)
            replaceFragment(ChatsFragment())
            commit()
        }

        //Make the View FullScreen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        var profileIcon = findViewById<ImageView>(R.id.profile_image)

        profileIcon.setOnClickListener {
            val intent = Intent(this, Account::class.java)
            startActivity(intent)
        }

        tv_chats.setOnClickListener {
            tv_chats.setBackgroundResource(R.drawable.gorillaz_camo_pattern_full)
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment, chatsFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}