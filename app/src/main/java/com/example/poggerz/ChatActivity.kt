package com.example.poggerz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poggerz.AuthenticationActivity
import com.example.poggerz.NoteAdapter
import com.example.poggerz.R
import com.example.poggerz.model.Note
import com.example.poggerz.utils.Constants
import com.example.poggerz.utils.Firestore
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {

    private val poggerzdb = Firebase.firestore.collection(Constants.NOTES)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val userId = intent.getStringExtra(Constants.LOGGED_IN_ID)

        if (userId != null) {
            Firestore().getUserInfoById(this, userId)

        } else {
            startActivity(Intent(this, AuthenticationActivity::class.java))
        }





        subscribeToNotesUpdates()

        btn_add.setOnClickListener {
            //getting input from user
            val title = et_new_note.text.toString()
            val note = Note(title, false)

            Firestore().saveNote(this, note)

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

    fun subscribeToNotesUpdates() {
        poggerzdb.addSnapshotListener { querySnapshot: QuerySnapshot?, error: FirebaseFirestoreException? ->
            error?.let {
                Toast.makeText(this, error?.message, Toast.LENGTH_SHORT).show()
                return@addSnapshotListener

            }

            var notesList = mutableListOf<Note>()

            querySnapshot?.let {

                for (document in it) {
                    val note = document.toObject<Note>()

                    notesList.add(note)

                }

                //adapter - add new list to recyclerview
                val adapter = NoteAdapter(notesList)
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
