package com.example.poggerz.utils

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.example.poggerz.AuthenticationActivity
import com.example.poggerz.MainActivity
import com.example.poggerz.models.User
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

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

    fun getUserInfoById(activity: MainActivity, uid: String) {

        val task = db.collection(Constants.USERS)
                .document(uid)
                .get()
                .addOnSuccessListener {document ->
                    if (document != null) {
                        val user= document.toObject(User::class.java)!!
                        activity.setUserInfo(user)
                    }else {
                        Toast.makeText(activity, "The user Info is empty", Toast.LENGTH_SHORT).show()
                    }

                } .addOnFailureListener {exception ->
                    Log.d(TAG, " get dailed in ", exception)


                }
    }


}
