package com.example.poggerz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.poggerz.utils.Constants
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class TestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_layout)

    }
}