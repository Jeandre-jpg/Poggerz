package com.example.poggerz

import android.content.Intent
import android.os.Bundle
import com.example.poggerz.fragments.LoginFragment
import com.example.poggerz.fragments.RegisterFragment
import com.example.poggerz.model.User
import com.example.poggerz.utils.Constants
import com.example.poggerz.utils.Firestore
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_authentication.*

class AuthenticationActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)


        //reference to our fragments
        val loginFragment = LoginFragment()
        val registerFragment = RegisterFragment()

        //setting the default fragment
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, loginFragment)
            commit()
        }

        tv_login.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment, loginFragment)
                addToBackStack(null)
                commit()
            }

            showErrorSnackBar("Hello World", true)
        }

        tv_register.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment, registerFragment)
                addToBackStack(null)
                commit()
            }
        }
    }

    fun registerUser(email: String, password: String, name: String, age: String) {

        if (email == "" || password == "") {
            showErrorSnackBar("Please provide the required information", true)
        } else {

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(
                            OnCompleteListener<AuthResult> { task ->
                                if (task.isSuccessful) {
                                    val firebaseUser: FirebaseUser = task.result!!.user!!
                                    //testing
                                    //   showErrorSnackBar("Successfully Registered user uid ${firebaseUser.uid}", false)

                                    //Creates User Data

                                    val user = User(
                                        firebaseUser.uid,
                                        email,
                                        name,
                                        null
                                    )

                                    //Call Firestore
                                    Firestore.registerUser(this, user)

                                } else {
                                    showErrorSnackBar(task.exception!!.message.toString(), true)
                                }
                            }
                    )
        }
    }

    fun loginUser(email: String, password: String) {

        if (email == "" || password == "") {
            showErrorSnackBar("Please enter your email & password", true)
        } else {

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(
                            OnCompleteListener<AuthResult> { task ->
                                if (task.isSuccessful) {
                                    val firebaseUser: FirebaseUser = task.result!!.user!!

                                    //  showErrorSnackBar("Successfully Logged In user uid ${firebaseUser.uid}", false)

                                    //TODO: add intent to navigate

                                    loginUserSuccess(firebaseUser.uid)

                                } else {
                                    showErrorSnackBar(task.exception!!.message.toString(), true)
                                }
                            }
                    )
        }

    }




    fun registerUserSuccess(uid: String) {
        showErrorSnackBar("Success on Registration", false)

        //TODO: Shared Prefrences

        //navigate to next Notes Activity and send the uid
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(Constants.LOGGED_IN_ID, uid)
        startActivity(intent)
        finish()
    }

    fun loginUserSuccess(uid: String) {

        //TODO: Shared Prefrences

        //navigate to next Notes Activity and send the uid
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(Constants.LOGGED_IN_ID, uid)
        startActivity(intent)
        finish()
    }

}