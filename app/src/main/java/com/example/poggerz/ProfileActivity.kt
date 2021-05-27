package com.example.poggerz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.poggerz.utils.Constants
import com.example.poggerz.utils.Firestore
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //Prepare SharedPreferences
        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        //Get active userID from SharedPrefs
        val userId = sharedPref.getString(Constants.LOGGED_IN_ID, "")

        //Use userID to update App with user object
        Firestore().getUserInfoById(this, userId!!)

        //Back button to Conversations Activity
        profile_appbar.setNavigationOnClickListener {
            val intent = Intent(this, MessagesActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}