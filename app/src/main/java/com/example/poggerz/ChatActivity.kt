package com.example.poggerz

import android.content.Context
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poggerz.model.Chats
import com.example.poggerz.utils.Constants
import com.example.poggerz.utils.Firestore
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_authentication.*
import kotlinx.android.synthetic.main.chat_layout.*
import java.util.*

class ChatActivity : AppCompatActivity() {

    private val messagesdb = Firebase.firestore.collection(Constants.CHATS)

    private var chatId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_layout)

     chatId = intent.getStringExtra("chatId").toString()
//
//        if (userId != null) {
//            Firestore().getUserInfoById(this, userId)
//
//        } else {
//            startActivity(Intent(this, ChatActivity::class.java))
//        }

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        val userId = sharedPref.getString(Constants.LOGGED_IN_ID, "uidHash")!!
        val loggedName = sharedPref.getString(Constants.LOGGED_IN_NAME, "null")

        editor.apply{
            putString(Constants.LOGGED_IN_ID, userId)
            apply()
        }



        subscribeToChatsUpdates()

        btn_add.setOnClickListener {
            //getting input from user
            val content = et_new_note.text.toString()
            val message = Chats(content, "Jeandré")

          Firestore().saveMessage(this, message, chatId)

            et_new_note.text.clear()
        }
    }





    fun setUserInfo(user: com.example.poggerz.model.User){
        title = user.name
    }







    fun setToolbarTitle(title:String){
        supportActionBar?.title = title
    }

    fun changeFragment(frag: Fragment){
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fl_fragment, frag).commit()
    }

    fun subscribeToChatsUpdates() {
        messagesdb.document(chatId).collection("messages").addSnapshotListener { querySnapshot: QuerySnapshot?, error: FirebaseFirestoreException? ->
            error?.let {
                Toast.makeText(this, error?.message, Toast.LENGTH_SHORT).show()
                return@addSnapshotListener

            }

            var messagesList = mutableListOf<Chats>()

            querySnapshot?.let {

                for (document in it) {
                    val message = document.toObject<Chats>()

                    messagesList.add(message)

                }

                //adapter - add new list to recyclerview
                val adapter = MessagesAdapter(messagesList)
                rv_notes.adapter = adapter
                rv_notes.layoutManager = LinearLayoutManager(this)

                for (dc in querySnapshot?.documentChanges) {
                    when (dc.type) {
                        DocumentChange.Type.ADDED -> Log.d("snapshotChanges", "New Note: " + dc.document.data)
                        DocumentChange.Type.MODIFIED -> Log.d("snapshotChanges", "New Note: " + dc.document.data)
                        DocumentChange.Type.REMOVED -> Log.d("snapshotChanges", "New Note: " + dc.document.data)
                    }

                }
            }
        }


    }
}
