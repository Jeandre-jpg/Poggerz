package com.example.poggerz.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.poggerz.R
import com.example.poggerz.AuthenticationActivity
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.et_email
import kotlinx.android.synthetic.main.fragment_register.et_password
import kotlinx.android.synthetic.main.fragment_register.view.*


class RegisterFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_register,container, false)

        //add our onclick
        view.btn_register.setOnClickListener {
            var email: String = et_email.text.toString().trim{ it <= ' ' }
            var password: String = et_password.text.toString().trim{ it <= ' ' }
            var name: String = et_name.text.toString()
            var age: String = et_age.text.toString()

            (activity as AuthenticationActivity?)!!.registerUser(email, password, name, age)
        }

        return view
    }
}