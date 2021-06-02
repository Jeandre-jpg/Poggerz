package com.example.poggerz.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.poggerz.ChatActivity

class ChatsFragment: Fragment(){

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val intent = Intent (this@ChatsFragment.context, ChatActivity::class.java)
        startActivity(intent)
    }
}