package com.example.poggerz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.poggerz.fragments.GroupsFragment
import com.example.poggerz.fragments.IndividualsFragment
import com.example.poggerz.model.Chat
import com.example.poggerz.model.User
import com.example.poggerz.utils.Constants
import com.example.poggerz.utils.Firestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_messages.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.chat_layout.*
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

        class ChatActivity : AppCompatActivity() {

            private val messagesdb = Firebase.firestore.collection(Constants.MESSAGES)
            private val usersdb = Firebase.firestore.collection(Constants.USERS)

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_chat)

                val individualsFragment = IndividualsFragment()
                val groupsFragment = GroupsFragment()

                //setting the default fragment
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fl_fragment, individualsFragment)
                    commit()
                }

                tv_individuals.setOnClickListener {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fl_fragment, individualsFragment)
                        addToBackStack(null)
                        commit()
                    }
                }

                tv_groups.setOnClickListener {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fl_fragment, groupsFragment)
                        addToBackStack(null)
                        commit()
                    }
                }



                //Prepare SharedPreferences
                val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)

                val editor = sharedPref.edit()

                //Get active userID from SharedPrefs
                val userId = sharedPref.getString(Constants.LOGGED_IN_ID, "uidHash")!!

                val loggedName = sharedPref.getString(Constants.LOGGED_IN_NAME, "null")


                editor.apply{
                    putString(Constants.LOGGED_IN_ID, userId)
                    apply()
                }

                getUserObject(userId)

                send_card.setOnClickListener {
                    val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
                    val currentDate = sdf.format(Date())
                    val content = message_content.text.toString()
                    val chat = Chat( content, loggedName!!, currentDate, false)
                  //  Firestore().sendMessage(this, chat)
                }

                tb_messages.setNavigationOnClickListener {
                    val intent = Intent(this, MessagesActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                subcribeToChatUpdates()
            }

            fun subcribeToChatUpdates(){
                val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
                val loggedName = sharedPref.getString(Constants.LOGGED_IN_NAME, "uidHash")!!
                messagesdb.addSnapshotListener{querySnapshot: QuerySnapshot?, error: FirebaseFirestoreException? ->

                    error?.let {
                        Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                    }

                    val chatList = mutableListOf<Chat>()

                    querySnapshot?.let{
                        for (document in it){
                            val chat = document.toObject<Chat>()

                            chatList.add(chat)
                        }
                        chatList.sortByDescending { it.datetime }
                        val recyclerView = findViewById<RecyclerView>(R.id.rvMessages)
                        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, true)
                        val adapter = ChatAdapter(chatList, loggedName)
                        recyclerView.adapter = adapter
                    }
                }
            }

            fun getUserObject(userId: String){

                val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()

                usersdb.document(userId).get().addOnSuccessListener { document ->
                    editor.apply{
                        putString(Constants.LOGGED_IN_NAME, document.toObject(User::class.java)!!.name)
                        apply()
                    }
                }
            }
        }