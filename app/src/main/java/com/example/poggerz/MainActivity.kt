package com.example.poggerz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.poggerz.fragments.*
import com.google.android.material.navigation.NavigationView
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
            R.id.signin -> {
                setToolbarTitle("Sign In")
                changeFragment(LoginFragment())
            }

            R.id.profile -> {
                setToolbarTitle("Profile")
                changeFragment(ProfileFragment())
            }

            R.id.people -> {
                setToolbarTitle("People")
                changeFragment(PeopleFragment())
            }

            R.id.chats -> {
                setToolbarTitle("Chats")
                changeFragment(ChatsFragment())
            }

            R.id.groups -> {
                setToolbarTitle("Groups")
                changeFragment(GroupsFragment())
            }

            R.id.logout -> {
                setToolbarTitle("Log Out")
                changeFragment(RegisterFragment())
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

    fun navigateToChats(){

    }


}