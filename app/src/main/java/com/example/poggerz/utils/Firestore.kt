package com.example.poggerz.utils

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.example.poggerz.AuthenticationActivity
import com.example.poggerz.ChatActivity
import com.example.poggerz.model.Chats
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.example.poggerz.model.User
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class Firestore {

    //initiate our firestore
    private val db= FirebaseFirestore.getInstance()

    fun registerUser(activity: AuthenticationActivity, userInfo: User){
        //TODO: adding to firestore

        db.collection(Constants.USERS)
                .document(userInfo.id)
                .set(userInfo, SetOptions.merge())
                .addOnSuccessListener {}

                .addOnFailureListener{

                    activity.showErrorSnackBar("Error while registering the user", true)

                }

    }

    val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())

    fun getUserInfoById(activity: ChatActivity, userId: String) {

        db.collection(Constants.USERS)
                .document(userId)
                .get()
                .addOnSuccessListener {document ->
                    if (document != null) {
                        val user: User = document.toObject(User::class.java)!!
                        activity.setUserInfo(user)
                    }else {
                        Toast.makeText(activity, "The user Info is empty", Toast.LENGTH_SHORT).show()
                    }

                } .addOnFailureListener {exception ->
                    Log.d(TAG, " get dailed in ", exception)


                }
    }




    private val  messagesdb = Firebase.firestore.collection(Constants.CHATS)

    fun saveMessage(activity: ChatActivity, messages: Chats, chatId: String) = CoroutineScope(Dispatchers.IO).launch {
        try {
            messagesdb.document(chatId).collection("messages").add(messages).await()
        } catch (e: Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}




