package com.example.poggerz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.poggerz.fragments.*
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        var toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        nav_menu.setNavigationItemSelectedListener(this)

        setToolbarTitle("Home")
        changeFragment(HomeFragment())


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer((GravityCompat.START))
        if (item.itemId == R.id.home){
            setToolbarTitle("Home")
            changeFragment(HomeFragment())
        }

        when(item.itemId){
            R.id.home -> {
                setToolbarTitle("Home")
                changeFragment(HomeFragment())
            }

            R.id.profile -> {
                setToolbarTitle("Profile")
                changeFragment(SettingsFragment())
            }

            R.id.chats -> {
                setToolbarTitle("Chats")
                changeFragment(ChatMainFragment())
            }

            R.id.people -> {
                setToolbarTitle("People")
                changeFragment(GroupsFragment())
            }

            R.id.conversations -> {
                setToolbarTitle("Conversations")
                changeFragment(IndividualsFragment())
            }

            R.id.logout -> {
                setToolbarTitle("Logout")
                changeFragment(LoginFragment())
            }

        }

        return true
    }

    fun setToolbarTitle(title:String){
        supportActionBar?.title = title
    }

    fun changeFragment(frag: Fragment){
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fragment_container, frag).commit()
    }

}