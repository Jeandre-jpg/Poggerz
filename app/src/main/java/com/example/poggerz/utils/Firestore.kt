package com.example.poggerz.utils

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.example.poggerz.*
import com.example.poggerz.model.Chat
import com.example.poggerz.model.User
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception

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

fun getUserInfoById(activity: ProfileActivity, userId: String) {

    db.collection(Constants.USERS)
        .document(userId)
        .get()
        .addOnSuccessListener {document ->
            if (document != null) {
                val user: User = document.toObject(User::class.java)!!
       //         activity.setUserInfoById(user)
            }else {
                Toast.makeText(activity, "The user Info is empty", Toast.LENGTH_SHORT).show()
            }

        } .addOnFailureListener {exception ->
            Log.d(TAG, " get dailed in ", exception)


        }
}

private val poggerzdb = Firebase.firestore.collection(Constants.NOTES)

fun saveNote(activity: MainActivity, chat: Chat) = CoroutineScope(Dispatchers.IO).launch{
    try {
        //add db
        poggerzdb.add(chat).await()
    }catch (e: Exception){
        //handle error
        withContext(Dispatchers.Main){
            Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
        }
    }

}


}


