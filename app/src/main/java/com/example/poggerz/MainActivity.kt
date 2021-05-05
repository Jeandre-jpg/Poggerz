package com.example.poggerz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ParcelFileDescriptor.open
import android.system.Os.close
import android.system.Os.open
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noted.R
import com.example.poggerz.fragments.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

//        //create list of notes
//        var notesList = mutableListOf(
//            Note("Note 1", false),
//            Note("Note 2", true)
//        )
//
//        //adapter
//        val adapter = NoteAdapter(notesList)
//        rv_notes.adapter = adapter
//        rv_notes.layoutManager = LinearLayoutManager(this)
//
//        btn_add.setOnClickListener {
//            val title = et_new_note.text.toString()
//            val note = Note(title, false)
//
//            notesList.add(note)
//
//            //notify adapter
//            adapter.notifyItemInserted(notesList.size - 1)
//
//            et_new_note.text.clear()
//        }

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

            R.id.individual_chats -> {
                setToolbarTitle("Individual Chats")
                changeFragment(IndividualsFragment())
            }

            R.id.group_chat -> {
                setToolbarTitle("Group Chats")
                changeFragment(GroupsFragment())
            }

            R.id.log_out -> {
                setToolbarTitle("Log Out")
                changeFragment(LoginFragment())
            }

            R.id.settings -> {
                setToolbarTitle("Settings")
                changeFragment(SettingsFragment())
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
