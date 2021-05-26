package com.example.poggerz.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poggerz.ChatActivity
import com.example.poggerz.R
import com.example.poggerz.recyclerview.item.PersonItem
import com.example.poggerz.util.Firestore
import com.google.firebase.firestore.ListenerRegistration
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.activity_chats.*
import kotlinx.android.synthetic.main.activity_chats.view.*
import kotlinx.android.synthetic.main.activity_chats.*
import kotlinx.android.synthetic.main.fragment_my_account.*

class ChatsFragment : Fragment() {

    private lateinit var userListenerRegistration: ListenerRegistration

    private var shouldInitRecyclerView = true

    private lateinit var chatsSection: Section

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        userListenerRegistration = Firestore.addUsersListener(this.activity!!, this::updateRecyclerView)

        Firestore.getCurrentUser { user ->
            Log.d("Get User Error", user.toString())
        }

        return inflater.inflate(R.layout.activity_chat, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Firestore.removeListener(userListenerRegistration)
        shouldInitRecyclerView = true
    }

    private fun updateRecyclerView(items: List<Item>) {

        fun init() {
            fl_fragment_chats.apply {
                layoutManager = LinearLayoutManager(this@ChatsFragment.context)
                adapter = GroupAdapter<GroupieViewHolder>().apply {
                    chatsSection = Section(items)
                    add(chatsSection)
                }
            }
            shouldInitRecyclerView = false
        }

        fun updateItems()  = chatsSection.update(items)

        if (shouldInitRecyclerView)
            init()
        else
            updateItems()
    }
}