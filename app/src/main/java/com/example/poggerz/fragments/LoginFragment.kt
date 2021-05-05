package com.example.poggerz.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.noted.R
import com.example.poggerz.AuthenticationActivity
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


        return view
    }
}