package com.example.poggerz.utils

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.example.poggerz.AuthenticationActivity
import com.example.poggerz.ChatActivity
import com.example.poggerz.model.Chats
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.example.poggerz.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.lang.NullPointerException
import java.text.SimpleDateFormat
import java.util.*

object Firestore {

    //Initiate our Firestore
    @SuppressLint("StaticFieldLeak")

    //initiate our firestore
    private val db= FirebaseFirestore.getInstance()
    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }


    //Register user to Firestore database
    fun registerUser(activity: AuthenticationActivity, userInfo: User) {

        //Collection -> document (uid from auth)
        db.collection(Constants.USERS)
            .document(userInfo.id)
            .set(userInfo, SetOptions.merge()) //set the new user (merge allows us to update user)
            .addOnSuccessListener {
                //Do this on success, navigate to next activity
                activity.registerUserSuccess(userInfo.id)
            }
            .addOnFailureListener {
                activity.showErrorSnackBar("Error while registering user...", true)
            }
    }

    private val currentUserDocRef: DocumentReference
        get() = firestoreInstance.document("user/${
            FirebaseAuth.getInstance().currentUser?.uid
            ?: throw NullPointerException("UID is null")
        }")



    fun updateCurrentUser(email: String = "", fullName: String = "", profilePicturePath: String? = null) {
        val userFieldMap = mutableMapOf<String, Any>()
        if (email.isNotBlank()) userFieldMap["email"] = email
        if (fullName.isNotBlank()) userFieldMap["fullName"] = fullName
        if (profilePicturePath != null) {
            userFieldMap["profileImagePath"] = profilePicturePath
        }
        currentUserDocRef.update(userFieldMap)
    }

    fun getCurrentUser(onComplete: (User) -> Unit) {
        currentUserDocRef.get()
            .addOnSuccessListener {
                onComplete(it.toObject(User::class.java)!!)
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




