package com.example.poggerz.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.poggerz.AuthenticationActivity
import com.example.poggerz.ChatActivity
import com.example.poggerz.R
import kotlinx.android.synthetic.main.fragment_individuals.view.*
import kotlinx.android.synthetic.main.fragment_individuals.*

class IndividualsFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_one.setOnClickListener {
            val intent = Intent (this@IndividualsFragment.context, ChatActivity::class.java)
            startActivity(intent)

        }

        btn_two.setOnClickListener {
            val intent = Intent (this@IndividualsFragment.context, ChatActivity::class.java)
            startActivity(intent)

        }

        btn_three.setOnClickListener {
            val intent = Intent (this@IndividualsFragment.context, ChatActivity::class.java)
            startActivity(intent)

        }

        btn_four.setOnClickListener {
            val intent = Intent (this@IndividualsFragment.context, ChatActivity::class.java)
            startActivity(intent)

        }


    }

}