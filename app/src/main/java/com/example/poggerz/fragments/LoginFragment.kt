package com.example.poggerz.fragments
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.poggerz.R
import com.example.poggerz.AuthenticationActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_register.*


class LoginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_login, container, false)

        view.btn_login.setOnClickListener {
            var email: String = et_email.text.toString().trim{ it <= ' ' }
            var password: String = et_password.text.toString().trim{ it <= ' ' }

            (activity as AuthenticationActivity?)!!.loginUser(email, password)

        }



//        val btn_google = Intent(Intent.ACTION_VIEW, Uri.parse("https://myaccount.google.com/?utm_source=sign_in_no_continue"))
//        startActivity(btn_google)
//
//        val btn_facebook = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pages/Log-in-Facbook/164923830322211"))
//        startActivity(btn_facebook)


        return view
    }
}