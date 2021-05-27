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

class MainActivity : AppCompatActivity() {

    private lateinit var drawer: DrawerLayout

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Get drawer by ID
        drawer = findViewById(R.id.drawer_layout)
        var navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        //Menu Icon
        var menu_icon = findViewById<ImageView>(R.id.burger_menu)

        //Toggle for navigation drawer open and close
        var toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawer,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        //On Menu Icon Click Open Menu
        menu_icon.setOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }

        var profileIcon = findViewById<ImageView>(R.id.profile_image)

        profileIcon.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_fragment, fragment)
            .commit()
    }

    val mOnNavigationItemSelectedListener = NavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home_menu -> {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                drawer.closeDrawer(GravityCompat.START)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile_menu -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                drawer.closeDrawer(GravityCompat.START)
                return@OnNavigationItemSelectedListener true
            }
            R.id.chats_menu -> {
                val intent = Intent(this, ChatActivity::class.java)
                startActivity(intent)
                drawer.closeDrawer(GravityCompat.START)
                return@OnNavigationItemSelectedListener true
            }
            R.id.users_menu -> {
                //Add Users Intent Activity Here
                drawer.closeDrawer(GravityCompat.START)
                return@OnNavigationItemSelectedListener true
            }
            R.id.logout_menu -> {
                val intent = Intent(this, AuthenticationActivity::class.java)
                startActivity(intent)
                drawer.closeDrawer(GravityCompat.START)
                return@OnNavigationItemSelectedListener true
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        false
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}

    }




}

