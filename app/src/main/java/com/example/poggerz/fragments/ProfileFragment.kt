package com.example.poggerz.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.poggerz.R
import com.example.poggerz.model.User
import com.example.poggerz.utils.Firestore
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

//    fun registerUser(email: String, password: String, name: String, age: String) {
//
//        if (email == "" || password == "") {
//            showErrorSnackBar("Please provide the required information", true)
//        } else {
//
//            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(
//                    OnCompleteListener<AuthResult> { task ->
//                        if (task.isSuccessful) {
//                            val firebaseUser: FirebaseUser = task.result!!.user!!
//                            //testing
//                            //   showErrorSnackBar("Successfully Registered user uid ${firebaseUser.uid}", false)
//
//                            //Creates User Data
//
//                            val user = User(
//                                firebaseUser.uid,
//                                name,
//                                email
//                            )
//
//                            //Call Firestore
//                            Firestore().registerUser(this, user)
//
//                        } else {
//                            showErrorSnackBar(task.exception!!.message.toString(), true)
//                        }
//                    }
//                )
//        }
//    }
//
//    fun loginUser(email: String, password: String) {
//
//        if (email == "" || password == "") {
//            showErrorSnackBar("Please enter your email & password", true)
//        } else {
//
//            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(
//                    OnCompleteListener<AuthResult> { task ->
//                        if (task.isSuccessful) {
//                            val firebaseUser: FirebaseUser = task.result!!.user!!
//
//                            //  showErrorSnackBar("Successfully Logged In user uid ${firebaseUser.uid}", false)
//
//                            //TODO: add intent to navigate
//
//                            loginUserSuccess(firebaseUser.uid)
//
//                        } else {
//                            showErrorSnackBar(task.exception!!.message.toString(), true)
//                        }
//                    }
//                )
//        }
//
//    }

}