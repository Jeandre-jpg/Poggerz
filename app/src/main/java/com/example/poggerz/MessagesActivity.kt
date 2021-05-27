package com.example.poggerz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.example.poggerz.model.User
import com.example.poggerz.utils.Constants
import com.example.poggerz.utils.Firestore
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_messages.*

class MessagesActivity : BaseActivity() {

    private val poggerzdb = Firebase.firestore.collection(Constants.USERS)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)
        //Set conversate toolbar as action bar
        setSupportActionBar(tb_messages)

        message_fab.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
            finish()
        }

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)

        val userID = sharedPref.getString(Constants.LOGGED_IN_ID, "not set")

       // Firestore().getUserInfo(this, userID!!)
    }

    //Inflate more options menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.conversations_app_bar, menu)
        return true
    }

    //Handle toolbar option selection
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, "blah", Toast.LENGTH_SHORT)

        //Get ID of selected item
        val id = item.itemId

        //Navigate to profile page
        if(id == R.id.profile_btn){
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
            return true
        }

        //Logout active user
        if(id == R.id.logout_btn){
            logoutUser()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    //Logout user and redirect to authentication
    fun logoutUser(){
        Firebase.auth.signOut()

        val intent = Intent(this, AuthenticationActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun setWelcome(userInfo: User){
        conversations_welcome.text = "Welcome, " + userInfo.name + "."
    }
}